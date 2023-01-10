package com.nubank.usecase;

import com.nubank.domain.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockOrderUseCaseTest {

    @Test
    void shouldReadAllOperationWithCorrectValues(){
        Locale.setDefault(new Locale("en", "US"));
        InputStream is = StockOrderUseCaseTest.class.getClassLoader().getResourceAsStream("file.txt");

        StockOrderUseCase stockOrderUseCase = new StockOrderUseCase();
        stockOrderUseCase.handle(is);

        assertEquals( 4, stockOrderUseCase.getOrderList().size());
        Assertions.assertEquals( Operation.BUY, stockOrderUseCase.getOrderList().get(0).getOperation());
        assertEquals( 10, stockOrderUseCase.getOrderList().get(0).getUnitCost());
        assertEquals( 10000, stockOrderUseCase.getOrderList().get(0).getQuantity());
        assertEquals( Operation.SELL, stockOrderUseCase.getOrderList().get(1).getOperation());
        assertEquals( 20, stockOrderUseCase.getOrderList().get(1).getUnitCost());
        assertEquals( 5000, stockOrderUseCase.getOrderList().get(1).getQuantity());
        assertEquals( Operation.BUY, stockOrderUseCase.getOrderList().get(2).getOperation());
        assertEquals( 20, stockOrderUseCase.getOrderList().get(2).getUnitCost());
        assertEquals( 10000, stockOrderUseCase.getOrderList().get(2).getQuantity());
        assertEquals( Operation.SELL, stockOrderUseCase.getOrderList().get(3).getOperation());
        assertEquals( 10, stockOrderUseCase.getOrderList().get(3).getUnitCost());
        assertEquals( 5000, stockOrderUseCase.getOrderList().get(3).getQuantity());
    }

}