package com.nubank;

import com.nubank.application.cli.CalculatedTaxesController;

public class CapitalGains {
    public static void main(String[] args) {
        CalculatedTaxesController calculatedTaxesController = new CalculatedTaxesController();
        calculatedTaxesController.doCalculate(System.in);
    }

}