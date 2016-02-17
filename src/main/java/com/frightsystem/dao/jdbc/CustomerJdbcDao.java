package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CustomerDao;
import com.frightsystem.model.Customer;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerJdbcDao extends AbstractJdbcDao implements CustomerDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO users(id, surname, name, thirdname, role, email, password, date_of_birth, skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM USERS WHERE role='customer'";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET id = ?, surname = ?, name = ?, thirdname = ?, role = ?, email = ?, password = ?, date_of_birth = ?, skype = ?, phone_number = ?";
    private static final String DUPLICATE_USER_MSG = "User with name {0} already exists";
    private static final String CREATE_USER_QUERY =
            "INSERT INTO \"user\" (name, surname) " +
                    "VALUES (?, ?)";
    private static final String READ_USER_BY_ID_QUERY =
            "SELECT * " +
                    "FROM \"user\" " +
                    "WHERE id = ?";
    // List<Customer> customers = new ArrayList<>();
    //  Statement statement = null;

    @Override
    public Customer create(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getThirdname());
            ps.setString(5, String.valueOf(customer.getRole()));
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, String.valueOf(customer.getDateOfBirth()));
            ps.setString(9, customer.getSkype());
            ps.setLong(10, customer.getPhoneNumder());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer read(int id) {
        Customer cstmr = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cstmr = new Customer();
                cstmr.setId(resultSet.getInt("id"));
                cstmr.setSurname(resultSet.getString("surname"));
                cstmr.setName(resultSet.getString("name"));
                cstmr.setThirdname(resultSet.getString("thirdname"));
                cstmr.setRole(resultSet.getString("role"));    // проверить работает ли метод setRole
                cstmr.setEmail(resultSet.getString("email"));
                cstmr.setPassword(resultSet.getString("password"));
                cstmr.setDateOfBirth(resultSet.getDate("date_of_birth"));
                cstmr.setSkype(resultSet.getString("skype"));
                cstmr.setPhoneNumder(resultSet.getShort("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cstmr;
    }

    @Override
    public boolean update(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getThirdname());
            ps.setString(5, String.valueOf(customer.getRole()));
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, String.valueOf(customer.getDateOfBirth()));
            ps.setString(9, customer.getSkype());
            ps.setLong(10, customer.getPhoneNumder());
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        return false;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            Customer cstmr = null;
            while (resultSet.next()) {
                cstmr = new Customer();
                cstmr.setId(resultSet.getInt("id"));
                cstmr.setSurname(resultSet.getString("surname"));
                cstmr.setName(resultSet.getString("name"));
                cstmr.setThirdname(resultSet.getString("thirdname"));
                cstmr.setRole(resultSet.getString("role"));    // проверить работает ли метод setRole
                cstmr.setEmail(resultSet.getString("email"));
                cstmr.setPassword(resultSet.getString("password"));
                cstmr.setDateOfBirth(resultSet.getDate("date_of_birth"));
                cstmr.setSkype(resultSet.getString("skype"));
                cstmr.setPhoneNumder(resultSet.getShort("phone_number"));
                customers.add(cstmr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
