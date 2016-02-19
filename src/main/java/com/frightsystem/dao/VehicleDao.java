package com.frightsystem.dao;

import com.frightsystem.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    public Vehicle create(Vehicle vehicle);

    public Vehicle read(int id);

    public boolean update(Vehicle vehicle);

    public boolean delete(Vehicle vehicle);

    public List<Vehicle> getAll();
}
