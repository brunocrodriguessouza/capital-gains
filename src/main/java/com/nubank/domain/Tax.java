package com.nubank.domain;

public class Tax {
    private final Double tax;

    public Tax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "{" +
                "\"tax\":" + String.format("%.2f",tax) +
                '}';
    }
}
