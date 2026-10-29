package com.example.QuickRelief.controller;

import com.example.QuickRelief.model.Supply;
import com.example.QuickRelief.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplies")
@CrossOrigin(origins = "*")
public class SupplyController {

    private final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    /**
     * POST /api/supplies: Add new emergency inventory items or restock existing supply levels.
     */
    @PostMapping
    public ResponseEntity<Supply> addOrRestockSupply(@RequestBody Supply supply) {
        Supply savedSupply = supplyService.addOrRestockSupply(supply);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupply);
    }

    /**
     * Auxiliary endpoint: POST /api/supplies/donation
     */
    @PostMapping("/donation")
    public ResponseEntity<Supply> createDonation(@RequestBody Supply supply) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyService.createSupply(supply));
    }

    /**
     * GET /api/supplies: View all available inventory using a custom JdbcTemplate RowMapper.
     */
    @GetMapping
    public ResponseEntity<List<Supply>> getAllSupplies() {
        return ResponseEntity.ok(supplyService.getAllSupplies());
    }

    /**
     * GET /api/supplies/{id}: View single supply item by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Long id) {
        return supplyService.getSupplyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * PUT /api/supplies/update/{id} and PUT /api/supplies/{id}
     */
    @PutMapping({"/update/{id}", "/{id}"})
    public ResponseEntity<Supply> updateSupply(@PathVariable Long id, @RequestBody Supply supply) {
        Supply updatedSupply = supplyService.updateSupply(id, supply);
        return ResponseEntity.ok(updatedSupply);
    }

    /**
     * DELETE /api/supplies/delete/{id} and DELETE /api/supplies/{id}
     */
    @DeleteMapping({"/delete/{id}", "/{id}"})
    public ResponseEntity<Void> deleteSupply(@PathVariable Long id) {
        supplyService.deleteSupply(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/supplies/donor/{donorId}
     */
    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<Supply>> getSuppliesByDonor(@PathVariable Long donorId) {
        return ResponseEntity.ok(supplyService.getSuppliesByDonor(donorId));
    }

    /**
     * GET /api/supplies/needs
     */
    @GetMapping("/needs")
    public ResponseEntity<List<Supply>> getSuppliesByNeed() {
        return ResponseEntity.ok(supplyService.getSuppliesByNeed());
    }
}
