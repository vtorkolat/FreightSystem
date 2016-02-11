package com.frightsystem.dao.jdbc;
import com.frightsystem.dao.CustomerDao;
import com.frightsystem.model.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerJdbcDao extends AbstractJdbcDao implements CustomerDao {
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
    public void create(Customer user) {

    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {    }

    @Override
    public void delete(Customer customer) {    }
    @Override
    public List<Customer> getAll() {
        return null;
    }
}
