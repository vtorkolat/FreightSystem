package com.frightsystem.dao.jdbc;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Stateless
public class CustomerJdbcDao extends AbstractJdbcDao {

    protected Connection connection;




}
