package com.nubank.usecase;

import com.google.gson.Gson;
import com.nubank.domain.Order;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StockOrderUseCase {

    public void handle(InputStream inputStream){
        List<String> operations = readInput(inputStream);
        this.orderList = convertToOrder(operations);
    }

    private List<Order> orderList;
//    private List<Integer> volumeOperations;

    public List<Order> getOrderList() {
        return Collections.unmodifiableList(orderList);
    }

//    public StockOrderUseCase(InputStream inputStream) {
//        List<String> operations = readInput(inputStream);
//        this.orderList = convertToOrder(operations);
//    }

    private List<Order> convertToOrder(List<String> operations) {
        List<Order> orderList = new ArrayList<>();
        Gson gson = new Gson();
        for(String operation : operations ){

            List<Order> orders = Arrays.stream(gson.fromJson(operation, Order[].class)).toList();
//            this.volumeOperations.add(orders.size());

            for(Order order: orders){
                orderList.add(order);
            }
        }

        return orderList;
    }

    private List<String> readInput(InputStream inputStream) {
//        InputStream inputStreamReader = new InputStream(inputStream);
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
                    sb = new StringBuilder("");
                }else{
                    sb.append(line);
                }
            }
        } catch (Exception e){
        }
        return lines;
    }

}
