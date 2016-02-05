package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.OrderDao;
import com.frightsystem.model.Order;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OrderJdbcDao extends AbstractJdbcDao implements OrderDao {
    List<Order> orders = new ArrayList<>();
    Statement statement = null;

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
