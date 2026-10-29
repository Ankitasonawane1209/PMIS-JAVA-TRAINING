package com.example.QuickRelief.exception;

import com.example.QuickRelief.model.SupplyRequest;

public class InsufficientStockException extends RuntimeException {

    private final SupplyRequest supplyRequest;

    public InsufficientStockException(String message) {
        super(message);
        this.supplyRequest = null;
    }

    public InsufficientStockException(String message, SupplyRequest supplyRequest) {
        super(message);
        this.supplyRequest = supplyRequest;
    }

    public SupplyRequest getSupplyRequest() {
        return supplyRequest;
    }
}
