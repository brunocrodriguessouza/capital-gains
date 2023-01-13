package com.nubank.usecase;

import com.nubank.domain.OperationType;
import com.nubank.domain.Order;
import com.nubank.domain.Tax;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTaxesUseCaseTest {

    @Test
    void shouldTestCase1(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 100),
                new Order(OperationType.SELL, 15.00, 50),
                new Order(OperationType.SELL, 15.00, 50)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(3, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
    }

    @Test
    void shouldTestCase2(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 20.00, 5000),
                new Order(OperationType.SELL, 5.00, 5000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(3, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(10000.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
    }

    @Test
    void shouldTestCase1AndCase2(){
        var simulation1 = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 100),
                new Order(OperationType.SELL, 15.00, 50),
                new Order(OperationType.SELL, 15.00, 50)
        );

        var simulation2 = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 20.00, 5000),
                new Order(OperationType.SELL, 5.00, 5000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation1);
        assertEquals(3, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());

        List<Tax> taxes2 = calculateTaxesUseCase.handle(simulation2);
        assertEquals(3, taxes2.size());
        assertEquals(0.00, taxes2.get(0).getTax());
        assertEquals(10000.00, taxes2.get(1).getTax());
        assertEquals(0.00, taxes2.get(2).getTax());
    }

    @Test
    void shouldTestCase3(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 5.00, 5000),
                new Order(OperationType.SELL, 20.00, 3000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(3, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(1000.00, taxes.get(2).getTax());
    }

    @Test
    void shouldTestCase4(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.BUY, 25.00, 5000),
                new Order(OperationType.SELL, 15.00, 10000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(3, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
    }

    @Test
    void shouldTestCase5(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.BUY, 25.00, 5000),
                new Order(OperationType.SELL, 15.00, 10000),
                new Order(OperationType.SELL, 25.00, 5000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(4, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
        assertEquals(10000.00, taxes.get(3).getTax());
    }


    @Test
    void shouldTestCase6(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 2.00, 5000),
                new Order(OperationType.SELL, 20.00, 2000),
                new Order(OperationType.SELL, 20.00, 2000),
                new Order(OperationType.SELL, 25.00, 1000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(5, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
        assertEquals(0.00, taxes.get(3).getTax());
        assertEquals(3000.00, taxes.get(4).getTax());
    }

    @Test
    void shouldTestCase7(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 2.00, 5000),
                new Order(OperationType.SELL, 20.00, 2000),
                new Order(OperationType.SELL, 20.00, 2000),
                new Order(OperationType.SELL, 25.00, 1000),
                new Order(OperationType.BUY, 20.00, 10000),
                new Order(OperationType.SELL, 15.00, 5000),
                new Order(OperationType.SELL, 30.00, 4350),
                new Order(OperationType.SELL, 30.00, 650)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(9, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(0.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
        assertEquals(0.00, taxes.get(3).getTax());
        assertEquals(3000.00, taxes.get(4).getTax());
        assertEquals(0.00, taxes.get(5).getTax());
        assertEquals(0.00, taxes.get(6).getTax());
        assertEquals(3700.00, taxes.get(7).getTax());
        assertEquals(0.00, taxes.get(8).getTax());

    }

    @Test
    void shouldTestCase8(){
        var simulation = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 50.00, 10000),
                new Order(OperationType.BUY, 20.00, 10000),
                new Order(OperationType.SELL, 50.00, 10000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation);
        assertEquals(4, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(80000.00, taxes.get(1).getTax());
        assertEquals(0.00, taxes.get(2).getTax());
        assertEquals(60000.00, taxes.get(3).getTax());
    }


    @Test
    void shouldTestCaseFirstExample(){
        var simulation1 = Arrays.asList(
                new Order(OperationType.BUY, 10.00, 10000),
                new Order(OperationType.SELL, 20.00, 5000)
        );

        var simulation2 = Arrays.asList(
                new Order(OperationType.BUY, 20.00, 10000),
                new Order(OperationType.SELL, 10.00, 5000)
        );

        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();
        List<Tax> taxes = calculateTaxesUseCase.handle(simulation1);
        assertEquals(2, taxes.size());
        assertEquals(0.00, taxes.get(0).getTax());
        assertEquals(10000.00, taxes.get(1).getTax());

        List<Tax> taxes2 = calculateTaxesUseCase.handle(simulation2);
        assertEquals(2, taxes2.size());
        assertEquals(0.00, taxes2.get(0).getTax());
        assertEquals(0.00, taxes2.get(1).getTax());
    }

}