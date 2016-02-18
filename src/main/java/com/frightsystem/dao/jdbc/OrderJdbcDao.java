package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.OrderDao;
import com.frightsystem.model.Order;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OrderJdbcDao extends AbstractJdbcDao implements OrderDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO orders (id, status, description, price) VALUES (?,?,?,?)";

    Statement statement = null;

    @Override
    public Order create(Order order) {
        try { Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, order.getId() );
            ps.setString(2, String.valueOf(order.getStatus()));
            ps.setString(3, order.getDescription());
            ps.setFloat(4, order.getPrice());
            ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
        return order;
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
        List<Order> orders = new ArrayList<>();

        return orders;
    }
}
