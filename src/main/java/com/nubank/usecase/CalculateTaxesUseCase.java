package com.nubank.usecase;

import com.nubank.domain.Order;
import com.nubank.domain.SimulationProperties;
import com.nubank.domain.Tax;

import java.util.List;

public class CalculateTaxesUseCase {

    public List<Tax> handle(List<Order> simulation){
        return calculateTaxes(simulation);
    }

    private List<Tax> calculateTaxes(List<Order> simulation){
        SimulationProperties simulationProperties = new SimulationProperties();
        simulation.forEach(order -> order.getOperation().execute(simulationProperties, order));

        return simulationProperties.getTaxes();
    }

}
