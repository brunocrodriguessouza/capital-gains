package com.nubank.usecase;

import com.nubank.domain.Order;
import com.nubank.domain.SimulationParameters;
import com.nubank.domain.Tax;

import java.util.List;

public class CalculateTaxesUseCase {

    public List<Tax> handle(List<Order> simulation){
        return calculateTaxes(simulation);
    }

    private List<Tax> calculateTaxes(List<Order> simulation){
        SimulationParameters simulationParameters = new SimulationParameters();
        simulation.forEach(order -> order.getOperation().execute(simulationParameters, order));

        return simulationParameters.getTaxes();
    }

}
