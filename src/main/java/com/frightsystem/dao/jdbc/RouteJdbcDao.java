package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.RouteDao;
import com.frightsystem.model.Route;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RouteJdbcDao extends AbstractJdbcDao implements RouteDao {
    List<Route> routs = new ArrayList<>();
    Statement statement = null;

    @Override
    public Route create() {
        return null;
    }

    @Override
    public Route read(int id) {
        return null;
    }

    @Override
    public void update(Route route) {

    }

    @Override
    public void delete(Route route) {

    }

    @Override
    public List<Route> getAll() {
        return null;
    }
}
