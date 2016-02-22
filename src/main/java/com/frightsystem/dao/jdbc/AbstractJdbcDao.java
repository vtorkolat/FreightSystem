package com.frightsystem.dao.jdbc;

import com.frightsystem.exceptions.CloseStatementException;
import com.frightsystem.util.ConnectionProvider;

import javax.ejb.Stateless;
import java.sql.*;

@Stateless
public class AbstractJdbcDao {
    protected Connection connection;

    private ConnectionProvider connectionProvider;

    public void init() {
        connection = connectionProvider.getConnection();
    }

    protected PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    protected Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CloseStatementException("Can't close statement", e);
        }
    }


}
