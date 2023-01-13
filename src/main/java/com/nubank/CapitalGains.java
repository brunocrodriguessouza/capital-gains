package com.nubank;

import com.nubank.application.cli.CalculatedTaxesController;

import java.util.Locale;

public class CapitalGains {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        CalculatedTaxesController calculatedTaxesController = new CalculatedTaxesController();
        calculatedTaxesController.doCalculate(System.in);
    }

}