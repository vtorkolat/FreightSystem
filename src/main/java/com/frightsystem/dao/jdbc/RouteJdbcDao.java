package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.RouteDao;
import com.frightsystem.model.Route;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RouteJdbcDao extends AbstractJdbcDao implements RouteDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO route (id, loadingAdress, unloadingAdress, date, time) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM route WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE route SET id = ?,loadingAdress=?, unloadingAdress = ?, date=?,time=? ";
    private static final String SQL_DELETE_BY_ID = "DELETE route WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM route";

    @Override
    public Route create(Route route) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return null;
    }

    @Override
    public Route read(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return null;
    }

    @Override
    public boolean update(Route route) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(Route route) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, route.getId());
            return   ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Route> getAll() {
        List<Route> routs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            Route route = null;
            while (resultSet.next()) {

                routs.add(route);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return routs;
    }
}
