package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.OrderDao;
import com.frightsystem.model.Order;
import com.frightsystem.model.enumerations.Status;

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
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM orders WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE orders SET id = ?,status=?, description = ?, price=?";
    private static final String SQL_DELETE_BY_ID = "DELETE orders WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM orders";

    @Override
    public Order create(Order order) {
        try ( Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, order.getId());
            ps.setString(2, String.valueOf(order.getStatus()));
            ps.setString(3, order.getDescription());
            ps.setFloat(4, order.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order read(int id) {
        Order ord = null;
        try ( Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                ord.setId(resultSet.getInt("id"));
                ord.setStatus(Status.fromString(resultSet.getString("status")));
                ord.setDescription(resultSet.getString("description"));
                ord.setPrice(resultSet.getFloat("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ord;
    }

    @Override
    public boolean update(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, order.getId());
            ps.setString(2, String.valueOf(order.getStatus()));
            ps.setString(3, order.getDescription());
            ps.setFloat(4, order.getPrice());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, order.getId());
         return   ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            Order order = null;
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setStatus(Status.fromString(resultSet.getString("status")));
                order.setDescription(resultSet.getString("description"));
                order.setPrice(resultSet.getFloat("price"));
                orders.add(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();}
        return orders;
    }
}
