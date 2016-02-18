package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.DriverDao;
import com.frightsystem.model.Driver;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DriverJdbcDao extends AbstractJdbcDao implements DriverDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO users(id, " +
            "surname, name, thirdname, role, email, password, date_of_birth, " +
            "skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";


    @Override
    public Driver create(Driver driver) {
        try { Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1,driver.getId());
        }catch (SQLException e){e.printStackTrace();}
        return driver;
    }


    @Override
    public Driver read(int id) {
        try {AbstractJdbcDao.init();

        }catch (SQLException e){e.printStackTrace();}
        return null;
    }

    @Override
    public void update(Driver driver) {
        try {
        }catch (SQLException e){e.printStackTrace();}

    }

    @Override
    public void delete(Driver driver) {
        try {
        }catch (SQLException e){e.printStackTrace();}

    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        try {
        }catch (SQLException e){e.printStackTrace();}
        return null;
    }
}
