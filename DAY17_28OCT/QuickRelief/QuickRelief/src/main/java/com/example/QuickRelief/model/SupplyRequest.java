package com.example.QuickRelief.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SupplyRequest {
    private Long id;

    @JsonProperty("itemName")
    @JsonAlias({"item_name", "itemName"})
    private String itemName;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("status")
    private String status;

    @JsonProperty("requestedBy")
    @JsonAlias({"requested_by", "requestedBy"})
    private String requestedBy;

    public SupplyRequest() {
    }

    public SupplyRequest(String itemName, Integer quantity, String requestedBy) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.requestedBy = requestedBy;
    }

    public SupplyRequest(Long id, String itemName, Integer quantity, String status, String requestedBy) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = status;
        this.requestedBy = requestedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    @Override
    public String toString() {
        return "SupplyRequest{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", requestedBy='" + requestedBy + '\'' +
                '}';
    }
}
