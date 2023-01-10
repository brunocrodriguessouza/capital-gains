package com.nubank;

import com.nubank.usecase.StockOrderUseCase;

import java.io.InputStream;
import java.util.Locale;

public class CapitalGains {
    public static void main(String[] args) {
        InputStream fis;
        fis = CapitalGains.class.getClassLoader().getResourceAsStream("file.txt");
        Locale.setDefault(new Locale("en", "US"));

        StockOrderUseCase stockOrderUseCase = new StockOrderUseCase();
        stockOrderUseCase.handle(fis);
    }
}