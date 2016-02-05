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
    List<Customer> customers = new ArrayList<>();
    Statement statement = null;

    @Override
    public Customer create() {
        return null;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
