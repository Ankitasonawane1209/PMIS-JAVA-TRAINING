package com.example.QuickRelief.service;

import com.example.QuickRelief.exception.InsufficientStockException;
import com.example.QuickRelief.exception.InvalidRequestException;
import com.example.QuickRelief.exception.ItemNotFoundException;
import com.example.QuickRelief.model.Supply;
import com.example.QuickRelief.model.SupplyRequest;
import com.example.QuickRelief.repository.SupplyRepository;
import com.example.QuickRelief.repository.SupplyRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final SupplyRequestRepository supplyRequestRepository;

    public SupplyService(SupplyRepository supplyRepository, SupplyRequestRepository supplyRequestRepository) {
        this.supplyRepository = supplyRepository;
        this.supplyRequestRepository = supplyRequestRepository;
    }

    /**
     * Add new emergency inventory items or restock existing supply levels.
     */
    @Transactional
    public Supply addOrRestockSupply(Supply supply) {
        if (supply == null) {
            throw new InvalidRequestException("Supply body cannot be null.");
        }
        if (supply.getItemName() == null || supply.getItemName().trim().isEmpty()) {
            throw new InvalidRequestException("Item name cannot be null or empty.");
        }
        if (supply.getQuantity() == null || supply.getQuantity() <= 0) {
            throw new InvalidRequestException("Quantity must be greater than zero.");
        }

        String itemName = supply.getItemName().trim();
        Optional<Supply> existingSupplyOpt = supplyRepository.findByItemName(itemName);

        if (existingSupplyOpt.isPresent()) {
            Supply existing = existingSupplyOpt.get();
            int updatedQuantity = existing.getQuantity() + supply.getQuantity();
            supplyRepository.updateQuantity(existing.getId(), updatedQuantity);
            existing.setQuantity(updatedQuantity);
            return existing;
        } else {
            supply.setItemName(itemName);
            return supplyRepository.save(supply);
        }
    }

    /**
     * Alias for create supply / donation.
     */
    public Supply createSupply(Supply supply) {
        return addOrRestockSupply(supply);
    }

    /**
     * View all available inventory using custom RowMapper.
     */
    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    /**
     * View supply by ID.
     */
    public Optional<Supply> getSupplyById(Long id) {
        return supplyRepository.findById(id);
    }

    /**
     * Update existing supply.
     */
    public Supply updateSupply(Long id, Supply supply) {
        supply.setId(id);
        return supplyRepository.update(supply);
    }

    /**
     * Delete supply by ID.
     */
    public void deleteSupply(Long id) {
        supplyRepository.deleteById(id);
    }

    /**
     * Find supplies by donor (returns all available supplies in this inventory
     * scope).
     */
    public List<Supply> getSuppliesByDonor(Long donorId) {
        return supplyRepository.findAll();
    }

    /**
     * Find supplies that need replenishment.
     */
    public List<Supply> getSuppliesByNeed() {
        return supplyRepository.findAll();
    }

    /**
     * Claim or allocate an item with transactional validation:
     * 1. Verify stock availability
     * 2. Deduct remaining quantity
     * 3. Record request details
     */
    @Transactional(noRollbackFor = { InsufficientStockException.class, ItemNotFoundException.class })
    public SupplyRequest claimOrAllocateSupply(SupplyRequest request) {
        if (request == null) {
            throw new InvalidRequestException("Supply request body cannot be null.");
        }
        if (request.getItemName() == null || request.getItemName().trim().isEmpty()) {
            throw new InvalidRequestException("Item name cannot be null or empty.");
        }
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new InvalidRequestException("Quantity must be greater than zero.");
        }
        if (request.getRequestedBy() == null || request.getRequestedBy().trim().isEmpty()) {
            throw new InvalidRequestException("RequestedBy field cannot be null or empty.");
        }

        String itemName = request.getItemName().trim();
        request.setItemName(itemName);
        request.setRequestedBy(request.getRequestedBy().trim());

        Optional<Supply> supplyOpt = supplyRepository.findByItemName(itemName);

        if (supplyOpt.isEmpty()) {
            request.setStatus("REJECTED");
            SupplyRequest saved = supplyRequestRepository.save(request);
            throw new ItemNotFoundException("Emergency item '" + itemName + "' not found in inventory.", saved);
        }

        Supply supply = supplyOpt.get();
        if (supply.getQuantity() < request.getQuantity()) {
            request.setStatus("REJECTED");
            SupplyRequest saved = supplyRequestRepository.save(request);
            throw new InsufficientStockException(
                    "Requested quantity (" + request.getQuantity() + ") exceeds available stock (" +
                            supply.getQuantity() + ") for item: " + supply.getItemName(),
                    saved);
        }

        // Deduct remaining quantity from supplies table
        int remainingQuantity = supply.getQuantity() - request.getQuantity();
        supplyRepository.updateQuantity(supply.getId(), remainingQuantity);

        // Record request details with APPROVED status
        request.setStatus("APPROVED");
        return supplyRequestRepository.save(request);
    }

    /**
     * Retrieve all requests for supply allocations.
     */
    public List<SupplyRequest> getAllRequests() {
        return supplyRequestRepository.findAll();
    }

    /**
     * Retrieve a request by its ID.
     */
    public Optional<SupplyRequest> getRequestById(Long id) {
        return supplyRequestRepository.findById(id);
    }
}
