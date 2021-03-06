package com.frightsystem.dao;

import com.frightsystem.model.Route;

import java.util.List;

/**
 * Created by JavaVadim on 05.02.2016.
 */
public interface RouteDao {

    public Route create(Route route);

    public Route read(int id);

    public boolean update(Route route);

    public boolean delete(Route route);

    public List<Route> getAll();
}
