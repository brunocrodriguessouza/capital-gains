package com.nubank.domain;

public interface Operation {
    void execute(SimulationProperties simulationProperties, Order order);
}
