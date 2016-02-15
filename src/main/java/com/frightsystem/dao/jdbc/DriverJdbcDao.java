package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.DriverDao;
import com.frightsystem.model.Driver;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DriverJdbcDao extends AbstractJdbcDao implements DriverDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    
    List<Driver> drivers = new ArrayList<>();
    Statement statement = null;

    @Override
    public Driver create() {
        return null;
    }

    @Override
    public Driver read(int id) {
        return null;
    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(Driver driver) {

    }

    @Override
    public List<Driver> getAll() {
        return null;
    }
}
