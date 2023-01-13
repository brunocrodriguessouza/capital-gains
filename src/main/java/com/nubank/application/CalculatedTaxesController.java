package com.nubank.application;

import com.nubank.domain.Order;
import com.nubank.usecase.CalculateTaxesUseCase;

import java.util.List;

public class CalculatedTaxesController {

    public void doCalculate(List<List<Order>> input){
        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();

        input.stream()
                .map(calculateTaxesUseCase::handle)
                .toList()
                .forEach(System.out::println);
    }

}
