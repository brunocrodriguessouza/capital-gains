package com.nubank.domain;

public interface Operation {
    void execute(SimulationParameters simulationParameters, Order order);
}
