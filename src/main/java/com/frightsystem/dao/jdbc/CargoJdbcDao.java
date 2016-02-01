package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CargoDao;
import com.frightsystem.model.Cargo;

import java.util.List;

public class CargoJdbcDao extends AbstractJdbcDao  implements CargoDao  {
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
