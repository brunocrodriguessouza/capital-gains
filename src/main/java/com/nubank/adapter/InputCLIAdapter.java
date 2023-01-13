package com.nubank.adapter;

import com.google.gson.Gson;
import com.nubank.application.CalculatedTaxesController;
import com.nubank.domain.Order;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCLIAdapter {

    public void handleInput(InputStream input){
        CalculatedTaxesController calculatedTaxesController = new CalculatedTaxesController();

        List<List<Order>> ordersByLine = convertToOrder(input);
        calculatedTaxesController.doCalculate(ordersByLine);
    }


    private List<List<Order>> convertToOrder(InputStream input) {
        List<String> lines = separateLines(input);
        List<List<Order>> orderList = new ArrayList<>();
        Gson gson = new Gson();

        lines.forEach(line -> orderList.add(Arrays.stream(gson.fromJson(line, Order[].class)).toList()));

        return orderList;
    }

    private List<String> separateLines(InputStream inputStream) {
        List<String> lines = new ArrayList<>();

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder sb = new StringBuilder();
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
