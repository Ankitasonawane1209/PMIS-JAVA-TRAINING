package com.example.QuickRelief.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientStock(InsufficientStockException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        if (ex.getSupplyRequest() != null) {
            body.put("id", ex.getSupplyRequest().getId());
            body.put("itemName", ex.getSupplyRequest().getItemName());
            body.put("quantity", ex.getSupplyRequest().getQuantity());
            body.put("status", ex.getSupplyRequest().getStatus());
            body.put("requestedBy", ex.getSupplyRequest().getRequestedBy());
        } else {
            body.put("status", "REJECTED");
        }
        body.put("error", "Insufficient Stock");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleItemNotFound(ItemNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        if (ex.getSupplyRequest() != null) {
            body.put("id", ex.getSupplyRequest().getId());
            body.put("itemName", ex.getSupplyRequest().getItemName());
            body.put("quantity", ex.getSupplyRequest().getQuantity());
            body.put("status", ex.getSupplyRequest().getStatus());
            body.put("requestedBy", ex.getSupplyRequest().getRequestedBy());
        } else {
            body.put("status", "REJECTED");
        }
        body.put("error", "Item Not Found");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRequest(InvalidRequestException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", "Invalid Request");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
