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

    private static final String SQL_INSERT = "INSERT INTO orders (id, status, description, price) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM orders WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE orders SET id = ?,status=?, description = ?, price=?";
    private static final String SQL_DELETE_BY_ID = "DELETE orders WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM orders";


    @Override
    public Order create(Order order) {
        PreparedStatement ps = null;
        try { ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1, order.getId());
            ps.setString(2, String.valueOf(order.getStatus()));
            ps.setString(3, order.getDescription());
            ps.setFloat(4, order.getPrice());

            int affectedRowsQua = ps.executeUpdate();
            System.out.println("Affected rows quantity: " + affectedRowsQua);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return order;
    }

    @Override
    public Order read(int id) {
        Order order = new Order();
        PreparedStatement ps = null;
        try { ps = getPreparedStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setStatus(Status.fromString(resultSet.getString("status")));
                order.setDescription(resultSet.getString("description"));
                order.setPrice(resultSet.getFloat("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return order;
    }

    @Override
    public boolean update(Order order) {
        PreparedStatement ps = null;
        try { ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, order.getId());
            ps.setString(2, String.valueOf(order.getStatus()));
            ps.setString(3, order.getDescription());
            ps.setFloat(4, order.getPrice());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public boolean delete(Order order) {
        PreparedStatement ps = null;
        try {ps = getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, order.getId());
         return   ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        Statement statement = null;
        try  {statement = getStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setStatus(Status.fromString(resultSet.getString("status")));
                order.setDescription(resultSet.getString("description"));
                order.setPrice(resultSet.getFloat("price"));
                orders.add(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();}
        finally {
            closeStatement(statement);
        }
        return orders;
    }
}
