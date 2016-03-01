package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.UserDao;
import com.frightsystem.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao extends AbstractJdbcDao implements UserDao {
    private static final String SQL_INSERT = "INSERT INTO users(id, email, password, ) VALUES (?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE users SET id = ?, email = ?, password = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE users WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM users";


    @Override
    public User create(User user) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int affectedRowsQua = ps.executeUpdate();
            System.out.println("Affected rows quantity: " + affectedRowsQua);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeStatement(ps);
        }
        return user;
    }

    @Override
    public User read(int id) {
        init();
        PreparedStatement ps = null;
        User user = new User();
        try {ps = getPreparedStatement(SQL_SELECT_BY_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        init();
        PreparedStatement ps = null;
        try { ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
           return ps.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        init();
        PreparedStatement ps = null;
        try{ ps = getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, user.getId());
            return ps.executeUpdate()==1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        init();
        List<User> users = new ArrayList<>();
        Statement statement = null;
        User user = new User();
        try {ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return users;
    }
}
