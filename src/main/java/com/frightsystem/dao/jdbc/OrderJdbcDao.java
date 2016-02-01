package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.OrderDao;
import com.frightsystem.model.Order;

import java.util.List;

/**
 * Created by JavaVadim on 01.02.2016.
 */
public class OrderJdbcDao extends AbstractJdbcDao implements OrderDao {
    @Override
    public Order create() {
        return null;
    }

    @Override
    public Order read(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
