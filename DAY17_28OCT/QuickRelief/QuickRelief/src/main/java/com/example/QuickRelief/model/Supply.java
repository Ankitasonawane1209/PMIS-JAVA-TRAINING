package com.example.QuickRelief.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Supply {
    private Long id;

    @JsonProperty("itemName")
    @JsonAlias({"item_name", "itemName"})
    private String itemName;

    @JsonProperty("quantity")
    private Integer quantity;

    public Supply() {
    }

    public Supply(String itemName, Integer quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public Supply(Long id, String itemName, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
