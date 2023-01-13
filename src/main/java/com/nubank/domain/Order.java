package com.nubank.domain;

import com.google.gson.annotations.SerializedName;

public class Order {

    public Order(OperationType operationType, Double unitCost, Integer quantity) {
        this.operationType = operationType;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    @SerializedName("operationType")
    private OperationType operationType;

    @SerializedName("unit-cost")
    private Double unitCost;
    private Integer quantity;

    public OperationType getOperation() {
        return operationType;
    }

    public void setOperation(OperationType operationType) {
        this.operationType = operationType;
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

}
