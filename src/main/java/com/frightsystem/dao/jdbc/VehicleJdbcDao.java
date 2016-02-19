package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.VehicleDao;
import com.frightsystem.model.Vehicle;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VehicleJdbcDao extends AbstractJdbcDao implements VehicleDao {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO vehicle (id, model, type, playload, volume) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM vehicle WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE vehicle SET id = ?,model=?, type = ?, playload=?, volume=?";
    private static final String SQL_DELETE_BY_ID = "DELETE vehicle WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM vehicle";


    @Override
    public Vehicle create(Vehicle vehicle) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return null;
    }

    @Override
    public Vehicle read(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return null;
    }

    @Override
    public boolean update(Vehicle vehicle) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, vehicle.getId());
            return   ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            Vehicle vehicle = null;
            while (resultSet.next()) {

                vehicles.add(vehicle);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
