package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.CargoDao;
import com.frightsystem.model.Cargo;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CargoJdbcDao extends AbstractJdbcDao implements CargoDao {

    private static final String SQL_INSERT = "INSERT INTO cargo (id, type, description, weight, volume) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cargo WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE cargo SET id = ?,type=?, description = ?, weight=?, volume=?";
    private static final String SQL_DELETE_BY_ID = "DELETE cargo WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM cargo";


    @Override
    public Cargo create(Cargo cargo) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_INSERT);

            ps.setInt(1, cargo.getId());
            ps.setString(2, cargo.getType());
            ps.setString(3, cargo.getDescription());
            ps.setFloat(4, cargo.getWeight());
            ps.setFloat(5, cargo.getVolume());
            int affectedRowsQua = ps.executeUpdate();
            System.out.println("Affected rows quantity: " + affectedRowsQua);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return cargo;
    }

    @Override
    public Cargo read(int id) {
        init();
        Cargo cargo = null;
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, id);
            while (rs.next()) {
                cargo.setId(rs.getInt("id"));
                cargo.setType(rs.getString("type"));
                cargo.setDescription(rs.getString("descriprion"));
                cargo.setWeight(rs.getFloat("weight"));
                cargo.setVolume(rs.getFloat("volume"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return cargo;
    }

    @Override
    public boolean update(Cargo cargo) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, cargo.getId());
            ps.setString(2, cargo.getType());
            ps.setString(3, cargo.getDescription());
            ps.setFloat(4, cargo.getWeight());
            ps.setFloat(5, cargo.getVolume());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;

    }

    @Override
    public boolean delete(Cargo cargo) {
        init();
        PreparedStatement ps = null;
        try {
           ps= getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, cargo.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        closeStatement(ps);
    } return false;
    }

    @Override
    public List<Cargo> getAll() {
       Cargo cargo = new Cargo();
        List<Cargo> cargos = new ArrayList<>();
        init();
        Statement statement = null;
        try  {
            statement=getStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {

                cargo.setId(rs.getInt("id"));
                cargo.setType(rs.getString("type"));
                cargo.setDescription(rs.getString("descriprion"));
                cargo.setWeight(rs.getFloat("weight"));
                cargo.setVolume(rs.getFloat("volume"));
                cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return cargos;
    }
}
