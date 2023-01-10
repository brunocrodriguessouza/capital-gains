package com.nubank.domain;

import com.google.gson.annotations.SerializedName;

public class Order {

    public Order(Operation operation, Double unitCost, Integer quantity) {
        this.operation = operation;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    @SerializedName("operation")
    private Operation operation;

    @SerializedName("unit-cost")
    private Double unitCost;
    private Integer quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        if(unitCost > 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Invalid Value");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if(quantity >0){
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Invalid Value");
        }
    }

    @Override
    public String toString() {
        return """
                [{\"operation\":\"%s\", \"unit-cost\":%.2f, \"quantity\":%d}]"""
                .formatted(operation.getValue(), unitCost, quantity ) ;
    }
}
