package com.example.QuickRelief.controller;

import com.example.QuickRelief.model.SupplyRequest;
import com.example.QuickRelief.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*")
public class SupplyRequestController {

    private final SupplyService supplyService;

    @Autowired
    public SupplyRequestController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    /**
     * POST /api/requests: Claim or allocate an item with transactional validation.
     * (verify stock availability, deduct remaining quantity, and record request details)
     */
    @PostMapping
    public ResponseEntity<SupplyRequest> claimOrAllocateSupply(@RequestBody SupplyRequest request) {
        SupplyRequest allocatedRequest = supplyService.claimOrAllocateSupply(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(allocatedRequest);
    }

    /**
     * GET /api/requests: View all supply request allocations.
     */
    @GetMapping
    public ResponseEntity<List<SupplyRequest>> getAllRequests() {
        List<SupplyRequest> requests = supplyService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    /**
     * GET /api/requests/{id}: View single supply request by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplyRequest> getRequestById(@PathVariable Long id) {
        return supplyService.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
