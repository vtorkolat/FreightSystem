package com.frightsystem.util;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.Connection;

@Singleton
@Startup
public class ConnectionProvider {
    private Connection connection;
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public Connection getConnection() {
        return connection;
    }

}
