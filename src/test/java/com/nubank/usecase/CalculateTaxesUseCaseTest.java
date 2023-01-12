package com.nubank.usecase;

import com.nubank.domain.Operation;
import com.nubank.domain.Order;
import com.nubank.domain.Tax;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTaxesUseCaseTest {


    @Test
    void shouldTestScenario1(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 100));
        line1.add(new Order(Operation.SELL, 15.00, 50));
        line1.add(new Order(Operation.SELL, 15.00, 50));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(3, taxes.get(0).size());

        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
    }

    @Test
    void shouldTestScenario2(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 20.00, 5000));
        line1.add(new Order(Operation.SELL, 5.00, 5000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(3, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(10000.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
    }

    @Test
    void shouldTestScenario1PlusScenario2(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 100));
        line1.add(new Order(Operation.SELL, 15.00, 50));
        line1.add(new Order(Operation.SELL, 15.00, 50));
        orders.add(line1);

        List<Order> line2 = new ArrayList<>();
        line2.add(new Order(Operation.BUY, 10.00, 10000));
        line2.add(new Order(Operation.SELL, 20.00, 5000));
        line2.add(new Order(Operation.SELL, 5.00, 5000));
        orders.add(line2);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(2, taxes.size());
        assertEquals(3, taxes.get(0).size());
        assertEquals(3, taxes.get(1).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
        assertEquals(0.00, taxes.get(1).get(0).getTax());
        assertEquals(10000.00, taxes.get(1).get(1).getTax());
        assertEquals(0.00, taxes.get(1).get(2).getTax());
    }

    @Test
    void shouldTestScenario3(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 5.00, 5000));
        line1.add(new Order(Operation.SELL, 20.00, 3000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(3, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(1000.00, taxes.get(0).get(2).getTax());
    }

    @Test
    void shouldTestScenario4(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.BUY, 25.00, 5000));
        line1.add(new Order(Operation.SELL, 15.00, 10000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(3, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
    }

    @Test
    void shouldTestScenario5(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.BUY, 25.00, 5000));
        line1.add(new Order(Operation.SELL, 15.00, 10000));
        line1.add(new Order(Operation.SELL, 25.00, 5000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(4, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
        assertEquals(10000.00, taxes.get(0).get(3).getTax());
    }


    @Test
    void shouldTestScenario6(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 2.00, 5000));
        line1.add(new Order(Operation.SELL, 20.00, 2000));
        line1.add(new Order(Operation.SELL, 20.00, 2000));
        line1.add(new Order(Operation.SELL, 25.00, 1000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(5, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
        assertEquals(0.00, taxes.get(0).get(3).getTax());
        assertEquals(3000.00, taxes.get(0).get(4).getTax());
    }

    @Test
    void shouldTestScenario7(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 2.00, 5000));
        line1.add(new Order(Operation.SELL, 20.00, 2000));
        line1.add(new Order(Operation.SELL, 20.00, 2000));
        line1.add(new Order(Operation.SELL, 25.00, 1000));
        line1.add(new Order(Operation.BUY, 20.00, 10000));
        line1.add(new Order(Operation.SELL, 15.00, 5000));
        line1.add(new Order(Operation.SELL, 30.00, 4350));
        line1.add(new Order(Operation.SELL, 30.00, 650));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(9, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(0.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
        assertEquals(0.00, taxes.get(0).get(3).getTax());
        assertEquals(3000.00, taxes.get(0).get(4).getTax());
        assertEquals(0.00, taxes.get(0).get(5).getTax());
        assertEquals(0.00, taxes.get(0).get(6).getTax());
        assertEquals(3700.00, taxes.get(0).get(7).getTax());
        assertEquals(0.00, taxes.get(0).get(8).getTax());
    }

    @Test
    void shouldTestScenario8(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 50.00, 10000));
        line1.add(new Order(Operation.BUY, 20.00, 10000));
        line1.add(new Order(Operation.SELL, 50.00, 10000));
        orders.add(line1);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(1, taxes.size());
        assertEquals(4, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(80000.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(0).get(2).getTax());
        assertEquals(60000.00, taxes.get(0).get(3).getTax());

    }


    @Test
    void shouldTestScenarioFirstExample(){
        List<List<Order>> orders = new ArrayList<>();
        List<Order> line1 = new ArrayList<>();
        line1.add(new Order(Operation.BUY, 10.00, 10000));
        line1.add(new Order(Operation.SELL, 20.00, 5000));
        orders.add(line1);

        List<Order> line2 = new ArrayList<>();
        line2.add(new Order(Operation.BUY, 20.00, 10000));
        line2.add(new Order(Operation.SELL, 10.00, 5000));
        orders.add(line2);

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<List<Tax>> taxes = calculateTaxesUseCase.handle(orders);
        assertEquals(2, taxes.size());
        assertEquals(2, taxes.get(0).size());
        assertEquals(0.00, taxes.get(0).get(0).getTax());
        assertEquals(10000.00, taxes.get(0).get(1).getTax());
        assertEquals(0.00, taxes.get(1).get(0).getTax());
        assertEquals(0.00, taxes.get(1).get(1).getTax());
    }



}