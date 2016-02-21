package com.frightsystem.dao;

import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Driver;

import java.util.List;


public interface DriverDao {

    public Driver create(Driver driver ) throws DuplicateUserException;

    public Driver read(int id);

    public boolean update(Driver driver);

    public boolean delete(Driver driver);

    public List<Driver> getAll();
}
