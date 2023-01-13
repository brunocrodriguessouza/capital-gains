package com.nubank.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimulationProperties {

    private BigDecimal mediumPrice;
    private Integer stockQuantity;

    private BigDecimal balance;
    private List<Tax> taxes;

    public SimulationProperties() {
        this.mediumPrice = BigDecimal.ZERO;
        this.stockQuantity = 0;
        this.balance = BigDecimal.ZERO;
        this.taxes = new ArrayList<>();
    }

    public BigDecimal getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(BigDecimal mediumPrice) {
        this.mediumPrice = mediumPrice;
    }


    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
