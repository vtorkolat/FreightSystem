package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CargoDao;
import com.frightsystem.model.Cargo;

import javax.ejb.Stateless;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CargoJdbcDao extends AbstractJdbcDao  implements CargoDao  {
    List<Cargo> cargo = new ArrayList<>();
    Statement statement = null;

    @Override
    public Cargo create() {
        return null;
    }

    @Override
    public Cargo read(int id) {
        return null;
    }

    @Override
    public void update(Cargo cargo) {

    }

    @Override
    public void delete(Cargo cargo) {

    }

    @Override
    public List<Cargo> getAll() {
        return null;
    }
}
