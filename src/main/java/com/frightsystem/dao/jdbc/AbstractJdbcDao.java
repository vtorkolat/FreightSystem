package com.frightsystem.dao.jdbc;

import com.frightsystem.util.ConnectionProvider;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.sql.Connection;

@Stateless
public class AbstractJdbcDao {

    protected Connection connection;

    private ConnectionProvider connectionProvider;

    @PostConstruct
    public void init() {
        connection = connectionProvider.getConnection();
    }



}
