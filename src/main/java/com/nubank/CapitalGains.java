package com.nubank;

import com.nubank.adapter.InputCLIAdapter;

import java.util.Locale;

public class CapitalGains {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        InputCLIAdapter inputCLIAdapter = new InputCLIAdapter();
        inputCLIAdapter.handleInput(System.in);
    }

}