package com.nubank.domain;

public class Tax {
    private Double tax;

    public Tax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
