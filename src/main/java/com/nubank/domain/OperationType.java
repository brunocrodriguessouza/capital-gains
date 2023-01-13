package com.nubank.domain;

import com.google.gson.annotations.SerializedName;

public enum OperationType implements Operation{

    @SerializedName("buy")
    BUY("buy"){
        @Override
        public void execute(SimulationParameters params, Order order) {
            params.updateAmountBuy( order.getQuantity() * order.getUnitCost());
            params.updateContractsBuy(order.getQuantity());
            params.setMediumPrice(params.format(params.getAmountBuy() / params.getContractsBuy()));
            params.getTaxes().add(new Tax(0.00));
            params.updateContracts(order.getQuantity());
        }
    },

    @SerializedName("sell")
    SELL("sell"){
        @Override
        public void execute(SimulationParameters params, Order order) {
            params.setSellPrice(params.format((order.getUnitCost() - params.getMediumPrice()) * order.getQuantity() ));
            params.updateBalance(params.getSellPrice());

            if(params.getSellPrice() > 0){
                params.updateProfit(params.getSellPrice());
            }
            if((params.getBalance() > 0 && params.getSellPrice() > 0 && params.getProfit() > 20000.00)){
                params.getTaxes().add(new Tax(params.getBalance() * 0.2));
                params.setBalance(params.getBalance() * 0.8);
                params.setProfit(0.00);
            }else {
                params.getTaxes().add(new Tax(0.00));
            }
            params.updateContracts(-1 * order.getQuantity());

            if(params.getContracts() == 0){
                params.setContractsBuy(0);
                params.setAmountBuy(0.00);
                params.setBalance(0.00);
            }
        }
    };

    private String value;

    OperationType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}


