package com.frightsystem.dao.jdbc;

import com.frightsystem.exceptions.CloseStatementException;
import com.frightsystem.util.ConnectionProvider;

import javax.ejb.Stateless;
import java.sql.*;

@Stateless
public abstract class AbstractJdbcDao {
    protected Connection connection;
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private ConnectionProvider connectionProvider;

    public static Connection init() {
        try {Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
