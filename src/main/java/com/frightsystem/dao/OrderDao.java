package com.frightsystem.dao;


import com.frightsystem.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderDao {

    public Order create();

    public Order read(int id);

    public void update(Order order);

    public void delete(Order order);

    public List<Order> getAll();


}
