package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CargoDao;
import com.frightsystem.model.Cargo;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CargoJdbcDao extends AbstractJdbcDao  implements CargoDao  {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FreightSystem";
    private static final String SQL_INSERT = "INSERT INTO cargo (id, type, description, weight, volume) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cargo WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE cargo SET id = ?,type=?, description = ?, weight=?, volume=?";
    private static final String SQL_DELETE_BY_ID = "DELETE cargo WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM cargo";

    @Override
    public Cargo create(Cargo cargo){
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
        Statement statement = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
        ps.setInt(1, cargo.getId());
        ps.setString(2, cargo.getType());
        ps.setString(3, cargo.getDescription());
        ps.setFloat(4, cargo.getWeight());
        ps.setFloat(5, cargo.getVolume());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();}
    return cargo;
    }

    @Override
    public Cargo read(int id) {
        Cargo cargo=null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return cargo;
    }

    @Override
    public boolean update(Cargo cargo) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

        } catch (SQLException e) {
            e.printStackTrace();}
        return false;

    }

    @Override
    public boolean delete(Cargo cargo) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, cargo.getId());
            return   ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Cargo> getAll() {
        List<Cargo> cargos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            Cargo cargo = null;
            while (resultSet.next()) {

                cargos.add(cargo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cargos;
    }
}
