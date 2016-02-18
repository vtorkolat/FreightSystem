package com.frightsystem.dao;


import com.frightsystem.model.Order;

import java.util.List;

public interface OrderDao {

    public Order create(Order order);

    public Order read(int id);

    public void update(Order order);

    public void delete(Order order);

    public List<Order> getAll();


}
