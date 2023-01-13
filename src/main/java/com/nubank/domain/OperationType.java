package com.nubank.domain;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum OperationType implements Operation{

    @SerializedName("buy")
    BUY(){
        @Override
        public void execute(SimulationProperties params, Order order) {

            var currentPrice = params.getMediumPrice().multiply(BigDecimal.valueOf(params.getStockQuantity()));
            var newPrice = BigDecimal.valueOf(order.getUnitCost() * order.getQuantity());

            params.setStockQuantity(params.getStockQuantity() + order.getQuantity());
            var quantity = BigDecimal.valueOf(params.getStockQuantity());
            var result = currentPrice.add(newPrice);

            if(params.getStockQuantity() > 0){
                result = result.divide(quantity, RoundingMode.HALF_UP);
            }

            params.setMediumPrice(result);

            params.getTaxes().add(new Tax(0.00));
        }
    },


    @SerializedName("sell")
    SELL(){
        @Override
        public void execute(SimulationProperties params, Order order) {
            var total = order.getQuantity() * order.getUnitCost();

            var previousTotal = params.getMediumPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
            params.setBalance(params.getBalance().add(BigDecimal.valueOf(total).subtract(previousTotal)));

            Tax tax = new Tax(0.00);

            if(total > TAX_LIMITED || params.getBalance().compareTo(BigDecimal.valueOf(TAX_LIMITED)) > 0 ){
                var totalTax = params.getBalance().multiply(BigDecimal.valueOf(0.20)).doubleValue();
                if(totalTax > 0){
                    tax = new Tax(totalTax);
                    params.setBalance(BigDecimal.ZERO);
                }
            }

            params.getTaxes().add(tax);
            params.setStockQuantity(params.getStockQuantity() - order.getQuantity());
        }
    };

    public static final int TAX_LIMITED = 20000;

}


