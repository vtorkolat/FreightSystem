package com.frightsystem.util;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@Startup
public class ConnectionProvider {
    private Connection connection;

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";

    public void init() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Can't connect to the DB");
            e.printStackTrace();
        }
String sql = "CREATE table user if not exist, WHERE id = ?";
        Statement statement= connection.createStatement();
        statement.execute(sql);
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Can't close connection to the DB");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}