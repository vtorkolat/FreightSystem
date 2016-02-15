package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.RouteDao;
import com.frightsystem.model.Route;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RouteJdbcDao extends AbstractJdbcDao implements RouteDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";

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
