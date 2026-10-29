package com.example.QuickRelief.exception;

import com.example.QuickRelief.model.SupplyRequest;

public class ItemNotFoundException extends RuntimeException {

    private final SupplyRequest supplyRequest;

    public ItemNotFoundException(String message) {
        super(message);
        this.supplyRequest = null;
    }

    public ItemNotFoundException(String message, SupplyRequest supplyRequest) {
        super(message);
        this.supplyRequest = supplyRequest;
    }

    public SupplyRequest getSupplyRequest() {
        return supplyRequest;
    }
}
