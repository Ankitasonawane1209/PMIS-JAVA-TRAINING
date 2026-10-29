package com.example.QuickRelief;

import com.example.QuickRelief.controller.SupplyController;
import com.example.QuickRelief.controller.SupplyRequestController;
import com.example.QuickRelief.exception.InsufficientStockException;
import com.example.QuickRelief.exception.ItemNotFoundException;
import com.example.QuickRelief.model.Supply;
import com.example.QuickRelief.model.SupplyRequest;
import com.example.QuickRelief.repository.SupplyRepository;
import com.example.QuickRelief.repository.SupplyRequestRepository;
import com.example.QuickRelief.service.SupplyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class QuickReliefServiceAndControllerTests {

    @Autowired
    private SupplyController supplyController;

    @Autowired
    private SupplyRequestController supplyRequestController;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private SupplyRequestRepository supplyRequestRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("DELETE FROM requests");
        jdbcTemplate.execute("DELETE FROM supplies");
    }

    @Test
    @DisplayName("POST /api/supplies - Add new emergency inventory item")
    void testAddNewEmergencySupply() {
        Supply newSupply = new Supply("First Aid Kit", 50);
        ResponseEntity<Supply> response = supplyController.addOrRestockSupply(newSupply);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getItemName()).isEqualTo("First Aid Kit");
        assertThat(response.getBody().getQuantity()).isEqualTo(50);

        List<Supply> inDb = supplyRepository.findAll();
        assertThat(inDb).hasSize(1);
        assertThat(inDb.get(0).getItemName()).isEqualTo("First Aid Kit");
    }

    @Test
    @DisplayName("POST /api/supplies - Restock existing supply level")
    void testRestockExistingSupplyLevel() {
        // First supply batch
        supplyController.addOrRestockSupply(new Supply("First Aid Kit", 50));

        // Restock batch
        ResponseEntity<Supply> restockResponse = supplyController.addOrRestockSupply(new Supply("First Aid Kit", 30));

        assertThat(restockResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(restockResponse.getBody()).isNotNull();
        assertThat(restockResponse.getBody().getQuantity()).isEqualTo(80);

        Supply fromDb = supplyRepository.findByItemName("First Aid Kit").orElseThrow();
        assertThat(fromDb.getQuantity()).isEqualTo(80);
    }

    @Test
    @DisplayName("GET /api/supplies - View all available inventory using custom RowMapper")
    void testViewAllAvailableInventory() {
        supplyController.addOrRestockSupply(new Supply("Emergency Food Rations", 100));
        supplyController.addOrRestockSupply(new Supply("Water Purification Tablets", 200));

        ResponseEntity<List<Supply>> response = supplyController.getAllSupplies();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getItemName()).isEqualTo("Emergency Food Rations");
        assertThat(response.getBody().get(0).getQuantity()).isEqualTo(100);
        assertThat(response.getBody().get(1).getItemName()).isEqualTo("Water Purification Tablets");
        assertThat(response.getBody().get(1).getQuantity()).isEqualTo(200);
    }

    @Test
    @DisplayName("POST /api/requests - Claim or allocate item with stock deduction & APPROVED record")
    void testClaimSupplySuccess() {
        // Setup initial inventory
        supplyController.addOrRestockSupply(new Supply("Medical Kit", 25));

        SupplyRequest request = new SupplyRequest("Medical Kit", 10, "Hostel Warden");
        ResponseEntity<SupplyRequest> response = supplyRequestController.claimOrAllocateSupply(request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo("APPROVED");
        assertThat(response.getBody().getQuantity()).isEqualTo(10);
        assertThat(response.getBody().getRequestedBy()).isEqualTo("Hostel Warden");

        // Verify stock deducted in inventory
        Supply updated = supplyRepository.findByItemName("Medical Kit").orElseThrow();
        assertThat(updated.getQuantity()).isEqualTo(15);

        // Verify record in requests table
        List<SupplyRequest> requestsInDb = supplyRequestRepository.findAll();
        assertThat(requestsInDb).hasSize(1);
        assertThat(requestsInDb.get(0).getStatus()).isEqualTo("APPROVED");
    }

    @Test
    @DisplayName("POST /api/requests - Edge case: rejects request exceeding available stock")
    void testClaimSupplyInsufficientStock() {
        supplyController.addOrRestockSupply(new Supply("Drinking Water Pack", 10));

        SupplyRequest request = new SupplyRequest("Drinking Water Pack", 50, "Campus Volunteers");

        InsufficientStockException ex = assertThrows(
                InsufficientStockException.class,
                () -> supplyService.claimOrAllocateSupply(request)
        );

        assertThat(ex.getMessage()).contains("exceeds available stock");

        // Verify stock is untouched (transaction safety)
        Supply intact = supplyRepository.findByItemName("Drinking Water Pack").orElseThrow();
        assertThat(intact.getQuantity()).isEqualTo(10);

        // Verify rejection is recorded
        List<SupplyRequest> requestsInDb = supplyRequestRepository.findAll();
        assertThat(requestsInDb).hasSize(1);
        assertThat(requestsInDb.get(0).getStatus()).isEqualTo("REJECTED");
    }

    @Test
    @DisplayName("POST /api/requests - Edge case: rejects request for non-existent item")
    void testClaimSupplyItemNotFound() {
        SupplyRequest request = new SupplyRequest("Blanket", 5, "Rescue Team");

        ItemNotFoundException ex = assertThrows(
                ItemNotFoundException.class,
                () -> supplyService.claimOrAllocateSupply(request)
        );

        assertThat(ex.getMessage()).contains("not found in inventory");

        // Verify rejection is recorded
        List<SupplyRequest> requestsInDb = supplyRequestRepository.findAll();
        assertThat(requestsInDb).hasSize(1);
        assertThat(requestsInDb.get(0).getStatus()).isEqualTo("REJECTED");
    }
}
