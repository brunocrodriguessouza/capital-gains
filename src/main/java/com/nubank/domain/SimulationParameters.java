package com.nubank.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SimulationParameters {

    private Integer contractsBuy, contracts;
    private Double balance, amountBuy, mediumPrice, profit, sellBalance;
    private List<Tax> taxes;

    public SimulationParameters() {
        this.contractsBuy = 0;
        this.contracts = 0;
        this.balance = 0.0;
        this.amountBuy = 0.0;
        this.mediumPrice = 0.0;
        this.profit = 0.0;
        this.sellBalance = 0.0;
        this.taxes = new ArrayList<>();
    }

    public Integer getContractsBuy() {
        return contractsBuy;
    }

    public void setContractsBuy(Integer contractsBuy) {
        this.contractsBuy = contractsBuy;
    }

    public void updateContractsBuy(Integer value){
        this.contractsBuy += value;
    }

    public Integer getContracts() {
        return contracts;
    }

    public void updateContracts(Integer value){
        this.contracts += value;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void updateBalance(Double value){
        this.balance += value;
    }

    public Double getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(Double amountBuy) {
        this.amountBuy = amountBuy;
    }

    public void updateAmountBuy(Double value){
        this.amountBuy += value;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(Double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public void updateProfit(Double value){
        this.profit += value;
    }

    public Double getSellBalance() {
        return sellBalance;
    }

    public void setSellBalance(Double sellBalance) {
        this.sellBalance = sellBalance;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public double format(double value){
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
