package com.frightsystem.dao;

import com.frightsystem.model.Cargo;

import java.util.List;

public interface CargoDao {

    public Cargo create(Cargo cargo);

    public Cargo read(int id);

    public boolean update(Cargo cargo);

    public boolean delete(Cargo cargo);

    public List<Cargo> getAll();

}
