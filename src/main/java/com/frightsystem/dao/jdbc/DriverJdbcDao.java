package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.DriverDao;
import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Driver;

import javax.ejb.Stateless;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DriverJdbcDao extends AbstractJdbcDao implements DriverDao {
    private static final String SQL_INSERT = "INSERT INTO users(id, surname, name, thirdname, role, email, password, date_of_birth, skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET id = ?, surname = ?, name = ?, thirdname = ?, role = ?, email = ?, password = ?, date_of_birth = ?, skype = ?, phone_number = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE users WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM users WHERE role='driver'";

    private static final String DUPLICATE_USER_MSG = "User with name {0} already exists";
  /* private static final String SQL_INSERT = "INSERT INTO users(id, " +
            "surname, name, thirdname, role, email, password, date_of_birth, " +
            "skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";*/



    @Override
    public Driver create(Driver driver) throws DuplicateUserException {
        PreparedStatement ps = null;
        try {ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1,driver.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DuplicateUserException(MessageFormat.format(DUPLICATE_USER_MSG, driver.getName()), e);
        }finally {
            closeStatement(ps);
        }
        return driver;
    }


    @Override
    public Driver read(int id) {
        PreparedStatement ps = null;
        try  {ps = getPreparedStatement(SQL_SELECT_BY_ID);

        }catch (SQLException e){e.printStackTrace();}
        return null;
    }

    @Override
    public boolean update(Driver driver) {
        try ( Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        }catch (SQLException e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(Driver driver) {
        try ( Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        }catch (SQLException e){e.printStackTrace();}
        return false;
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        Statement statement = null;
        try  {statement = getStatement();
            ResultSet rs = statement.executeQuery();

        }catch (SQLException e)
            {e.printStackTrace();
        }finally {
            closeStatement(statement);
        }
        return drivers;
    }
}
