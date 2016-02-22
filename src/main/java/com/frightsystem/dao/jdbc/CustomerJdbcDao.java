package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CustomerDao;
import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Customer;
import com.frightsystem.model.enumerations.Role;

import javax.ejb.Stateless;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerJdbcDao extends AbstractJdbcDao implements CustomerDao {

    private static final String SQL_INSERT = "INSERT INTO users(id, surname, name, thirdname, role, email, password, date_of_birth, skype, phone_number) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET id = ?, surname = ?, name = ?, thirdname = ?, role = ?, email = ?, password = ?, date_of_birth = ?, skype = ?, phone_number = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE users WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM users WHERE role='customer'";

    private static final String DUPLICATE_USER_MSG = "User with name {0} already exists";
    private static final String CREATE_USER_QUERY =
            "INSERT INTO \"user\" (name, surname) " +
                    "VALUES (?, ?)";
    private static final String READ_USER_BY_ID_QUERY =
            "SELECT * " +
                    "FROM \"user\" " +
                    "WHERE id = ?";


    @Override
    public Customer create(Customer customer) throws DuplicateUserException {
       PreparedStatement ps=null;
        try {ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getThirdname());
            ps.setString(5, String.valueOf(customer.getRole()));
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, String.valueOf(customer.getDateOfBirth()));
            ps.setString(9, customer.getSkype());
            ps.setLong(10, customer.getPhoneNumder());
            int affectedRowsQua = ps.executeUpdate();
            System.out.println("Affected rows quantity: " + affectedRowsQua);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DuplicateUserException(MessageFormat.format(DUPLICATE_USER_MSG, customer.getName()), e);
        }finally {
            closeStatement(ps);
        }
        return customer;
    }

    @Override
    public Customer read(int id) {
        Customer cstmr = new Customer();
        PreparedStatement ps = null;
        try {ps = getPreparedStatement(SQL_SELECT_BY_ID);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                cstmr.setId(rs.getInt("id"));
                cstmr.setSurname(rs.getString("surname"));
                cstmr.setName(rs.getString("name"));
                cstmr.setThirdname(rs.getString("thirdname"));
                cstmr.setRole(String.valueOf(Role.fromString(rs.getString("role"))));    // проверить работает ли метод setRole
                cstmr.setEmail(rs.getString("email"));
                cstmr.setPassword(rs.getString("password"));
                cstmr.setDateOfBirth(rs.getDate("date_of_birth"));
                cstmr.setSkype(rs.getString("skype"));
                cstmr.setPhoneNumder(rs.getShort("phone_number"));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return cstmr;
    }

    @Override
    public boolean update(Customer customer) {
        PreparedStatement ps = null;
        try {ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getThirdname());
            ps.setString(5, String.valueOf(customer.getRole()));
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, String.valueOf(customer.getDateOfBirth()));
            ps.setString(9, customer.getSkype());
            ps.setLong(10, customer.getPhoneNumder());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        PreparedStatement ps = null;
        try {ps = getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, customer.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Statement statement = null;
        try  {statement = getStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Customer cstmr = new Customer();
                cstmr.setId(rs.getInt("id"));
                cstmr.setSurname(rs.getString("surname"));
                cstmr.setName(rs.getString("name"));
                cstmr.setThirdname(rs.getString("thirdname"));
                cstmr.setRole(rs.getString("role"));    // проверить работает ли метод setRole
                cstmr.setEmail(rs.getString("email"));
                cstmr.setPassword(rs.getString("password"));
                cstmr.setDateOfBirth(rs.getDate("date_of_birth"));
                cstmr.setSkype(rs.getString("skype"));
                cstmr.setPhoneNumder(rs.getShort("phone_number"));
                customers.add(cstmr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return customers;
    }
}
