package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.VehicleDao;
import com.frightsystem.model.Vehicle;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VehicleJdbcDao extends AbstractJdbcDao implements VehicleDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";

    List<Vehicle> vehicles = new ArrayList<>();
    Statement statement = null;

    @Override
    public Vehicle create() {
        return null;
    }

    @Override
    public Vehicle read(int id) {
        return null;
    }

    @Override
    public void update(Vehicle vehicle) {

    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }
}
