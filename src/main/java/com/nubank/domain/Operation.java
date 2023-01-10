package com.nubank.domain;

import com.google.gson.annotations.SerializedName;

public enum Operation {

    @SerializedName("buy")
    BUY("buy"),

    @SerializedName("sell")
    SELL("sell");

    private String value;

    Operation(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
