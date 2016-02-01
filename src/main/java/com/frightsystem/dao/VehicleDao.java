package com.frightsystem.dao;

import com.frightsystem.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    public Vehicle create();

    public Vehicle read(int id);

    public void update(Vehicle vehicle);

    public void delete(Vehicle vehicle);

    public List<Vehicle> getAll();
}
