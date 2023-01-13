package com.nubank.application.cli;

import com.google.gson.Gson;
import com.nubank.domain.Order;
import com.nubank.usecase.CalculateTaxesUseCase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatedTaxesController {

    public void doCalculate(InputStream input){
        CalculateTaxesUseCase calculateTaxesUseCase = new CalculateTaxesUseCase();

        List<List<Order>> ordersByLine = convertToOrder(input);
        ordersByLine.stream()
                .map(calculateTaxesUseCase::handle)
                .toList()
                .forEach(System.out::println);
    }


    private List<List<Order>> convertToOrder(InputStream input) {
        List<String> lines = separateLines(input);
        List<List<Order>> orderList = new ArrayList<>();
        Gson gson = new Gson();

        for(String line : lines ){
            List<Order> orders = Arrays.stream(gson.fromJson(line, Order[].class)).toList();
            orderList.add(orders);
        }

        return orderList;
    }

    private List<String> separateLines(InputStream inputStream) {
        List<String> lines = new ArrayList<>();

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder sb = new StringBuilder("");
            while((line = bufferedReader.readLine()) != null){
                if(line.equals("")){
                    break;
                }
                if(line.contains("]")){
                    sb.append(line);
                    lines.add(sb.toString());
                    sb = new StringBuilder();
                }else{
                    sb.append(line);
                }
            }
        } catch (Exception e){
            throw new RuntimeException("Invalid InputStream");
        }
        return lines;
    }

}
