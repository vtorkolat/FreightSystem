package com.frightsystem.dao;

import com.frightsystem.model.Cargo;
import com.frightsystem.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CargoDao {

    public Cargo create();

    public Cargo read(int id);

    public void update(Cargo cargo);

    public void delete(Cargo cargo);

    public List<Cargo> getAll();

}
