package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.DriverDao;
import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Driver;
import com.frightsystem.model.enumerations.ActivityField;

import javax.ejb.Stateless;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DriverJdbcDao extends AbstractJdbcDao implements DriverDao {
    private static final String SQL_INSERT = "INSERT INTO users(id, surname, name, thirdname, role," +
            " email, password, date_of_birth, skype, phone_number, description,company_name, " +
            "activity_field, number_license, license_issue_date, vehicles) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET id = ?, surname = ?, name = ?, " +
            "thirdname = ?, role = ?, email = ?, password = ?, date_of_birth = ?, skype = ?, " +
            "phone_number = ?,description=?, company_name=?, activity_field=?  ";
    private static final String SQL_DELETE_BY_ID = "DELETE users WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM users WHERE role='driver'";

    private static final String DUPLICATE_USER_MSG = "User with name {0} already exists";
  /* private static final String SQL_INSERT = "INSERT INTO users(id, " +
            "surname, name, thirdname, role, email, password, date_of_birth, " +
            "skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";*/


    @Override
    public Driver create(Driver driver) throws DuplicateUserException {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1, driver.getId());
            ps.setString(2, driver.getSurname());
            ps.setString(3, driver.getName());
            ps.setString(4, String.valueOf(driver.getRole()));
            ps.setString(5, driver.getPassword());
            ps.setDate(6, (Date) driver.getDateOfBirth());
            ps.setString(7, driver.getSkype());
            ps.setShort(8, driver.getPhoneNumder());
            ps.setString(9, driver.getDescription());
            ps.setString(10, driver.getCompanyName());
            ps.setString(11, String.valueOf(driver.getActivityField()));
            ps.setString(12, driver.getNumberLicense());
            ps.setDate(13, (Date) driver.getLicenseIssueDate());
            ps.setString(14, String.valueOf(driver.getVehicles()));

            int affectedRowsQua = ps.executeUpdate();
            System.out.println("Affected rows quantity: " + affectedRowsQua);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DuplicateUserException(MessageFormat.format(DUPLICATE_USER_MSG, driver.getName()), e);
        } finally {
            closeStatement(ps);
        }
        return driver;
    }


    @Override
    public Driver read(int id) {
        Driver driver = new Driver();
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                driver.setId(rs.getInt("id"));
                driver.setSurname(rs.getString("surname"));
                driver.setName(rs.getString("name"));
                driver.setThirdname(rs.getString("thirdname"));
                driver.setRole(rs.getString("role"));
                driver.setEmail(rs.getString("email"));
                driver.setPassword(rs.getString("password"));
                driver.setDateOfBirth(rs.getDate("date_of_birth"));
                driver.setSkype(rs.getString("skype"));
                driver.setPhoneNumder(rs.getShort("phone_numder"));
                driver.setDescription(rs.getString("description"));
                driver.setCompanyName(rs.getString("company_name"));
                driver.setActivityField(ActivityField.fromString(rs.getString("aActivity_field")));
                driver.setNumberLicense(rs.getString("number_license"));
                driver.setLicenseIssueDate(rs.getDate("license_issue_date"));
                driver.setVehicles(rs.getString("vehicles"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return null;
    }

    @Override
    public boolean update(Driver driver) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, driver.getId());
            ps.setString(2, driver.getSurname());
            ps.setString(3, driver.getName());
            ps.setString(4, String.valueOf(driver.getRole()));
            ps.setString(5, driver.getPassword());
            ps.setDate(6, (Date) driver.getDateOfBirth());
            ps.setString(7, driver.getSkype());
            ps.setShort(8, driver.getPhoneNumder());
            ps.setString(9, driver.getDescription());
            ps.setString(10, driver.getCompanyName());
            ps.setString(11, String.valueOf(driver.getActivityField()));
            ps.setString(12, driver.getNumberLicense());
            ps.setDate(13, (Date) driver.getLicenseIssueDate());
            ps.setString(14, String.valueOf(driver.getVehicles()));

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public boolean delete(Driver driver) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, driver.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        init();
        List<Driver> drivers = new ArrayList<>();
        Statement statement = null;
        Driver driver = new Driver();
        try {statement = getStatement();
             ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                driver.setId(rs.getInt("id"));
                driver.setSurname(rs.getString("surname"));
                driver.setName(rs.getString("name"));
                driver.setThirdname(rs.getString("thirdname"));
                driver.setRole(rs.getString("role"));
                driver.setEmail(rs.getString("email"));
                driver.setPassword(rs.getString("password"));
                driver.setDateOfBirth(rs.getDate("date_of_birth"));
                driver.setSkype(rs.getString("skype"));
                driver.setPhoneNumder(rs.getShort("phone_numder"));
                driver.setDescription(rs.getString("description"));
                driver.setCompanyName(rs.getString("company_name"));
                driver.setActivityField(ActivityField.fromString(rs.getString("aActivity_field")));
                driver.setNumberLicense(rs.getString("number_license"));
                driver.setLicenseIssueDate(rs.getDate("license_issue_date"));
                driver.setVehicles(rs.getString("vehicles"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return drivers;
    }
}
