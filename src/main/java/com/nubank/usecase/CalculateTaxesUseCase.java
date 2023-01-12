package com.nubank.usecase;

import com.nubank.domain.Operation;
import com.nubank.domain.Order;
import com.nubank.domain.Tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CalculateTaxesUseCase {

    public List<Tax> handle(List<Order> simulation){
        return calculateTaxes(simulation);
    }

    private List<Tax> calculateTaxes(List<Order> simulation){
        int contractsBuy = 0;
        int contracts = 0;
        double balance = 0, amountBuy = 0, mediumPrice = 0, profit = 0, sellBalance;
        List<Tax> taxes = new ArrayList<>();

        for(Order order: simulation){
            if(order.getOperation().equals(Operation.BUY)){
                amountBuy += order.getQuantity() * order.getUnitCost();
                contractsBuy += order.getQuantity();
                mediumPrice = roundDouble2Decimals(amountBuy / contractsBuy);
                taxes.add(new Tax(0.00));
                contracts += order.getQuantity();
            }
            if(order.getOperation().equals(Operation.SELL)){
                sellBalance = roundDouble2Decimals((order.getUnitCost() - mediumPrice) * order.getQuantity());
                balance += sellBalance;
                if(sellBalance > 0){
                    profit += sellBalance;
                }
                if((balance > 0 && sellBalance > 0 && profit > 20000.00)){
                    taxes.add(new Tax(balance * 0.2));
                    balance *= 0.8;
                    profit = 0;
                }else {
                    taxes.add(new Tax(0.00));
                }
                contracts -= order.getQuantity();
                if(contracts == 0){
                    contractsBuy = 0;
                    amountBuy = 0;
                    balance = 0;
                }
            }
        }

        return taxes;
    }

    private double roundDouble2Decimals(double value){
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}



