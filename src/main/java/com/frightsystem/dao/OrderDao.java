package com.frightsystem.dao;


import com.frightsystem.model.Order;
import com.frightsystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class OrderDao {
    private static OrderDao instance;
    private Map<String, Order> orders = new HashMap<>();

    private OrderDao(){}

    public static OrderDao getInstance(){
        if (instance == null){
            instance = new OrderDao();
        } return instance;
    }


    public Order getOrder (int id){return orders.get(id); }

}
