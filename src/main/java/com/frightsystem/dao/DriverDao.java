package com.frightsystem.dao;

import com.frightsystem.model.Driver;

import java.util.List;


public interface DriverDao {

    public Driver create();

    public Driver read(int id);

    public void update(Driver driver);

    public void delete(Driver driver);

    public List<Driver> getAll();
}
