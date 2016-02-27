package com.frightsystem.dao.jdbc;

import com.frightsystem.dao.RouteDao;
import com.frightsystem.model.Route;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RouteJdbcDao extends AbstractJdbcDao implements RouteDao {

    private static final String SQL_INSERT = "INSERT INTO route (id, loading_adress, unloading_adress, loading_date, loading_time) " +
                                             "VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM route WHERE id = ?";
    private static final String SQL_UPDATE_BY_ID = "UPDATE route SET id = ?,FreightSystem=?, unloading_adress = ?, " +
                                                   "loading_date=?,loading_time=? ";
    private static final String SQL_DELETE_BY_ID = "DELETE route WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM route";

    @Override
    public Route create(Route route) {
        init();
        PreparedStatement ps = null;
        try { ps = getPreparedStatement(SQL_INSERT);
            ps.setInt(1, route.getId());
            ps.setString(2, route.getLoadingAdress());
            ps.setString(3, route.getUnloadingAdress());
            ps.setDate(4, (Date) route.getDate());
            ps.setTime(5, route.getTime());

            int affectedRowsQua= ps.executeUpdate();
            System.out.println("Affected rows quantity "+affectedRowsQua );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return route;
    }

    @Override
    public Route read(int id) {
        init();
        Route route = new Route();
        PreparedStatement ps = null;
        try  {ps = getPreparedStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                route.setId(rs.getInt("id"));
                route.setLoadingAdress(rs.getString("loading_adress"));
                route.setUnloadingAdress(rs.getString("unloading_adress"));
                route.setDate(rs.getDate("loading_date"));
                route.setTime(rs.getTime("loading_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return route;
    }

    @Override
    public boolean update(Route route) {
        init();
        PreparedStatement ps = null;
        try  {ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setInt(1, route.getId());
            ps.setString(2, route.getLoadingAdress());
            ps.setString(3, route.getUnloadingAdress());
            ps.setDate(4, (Date) route.getDate());
            ps.setTime(5, (Time) route.getDate());
            return ps.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public boolean delete(Route route) {
        init();
        PreparedStatement ps = null;
        try  {ps = getPreparedStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, route.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return false;
    }

    @Override
    public List<Route> getAll() {
        List<Route> routs = new ArrayList<>();
        Route route = new Route();
        init();
        Statement statement=null;
        try  {statement = getStatement();
              ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
          
            while (rs.next()) {

                route.setId(rs.getInt("id"));
                route.setLoadingAdress(rs.getString("loading_adress"));
                route.setUnloadingAdress(rs.getString("unloading_adress"));
                route.setDate(rs.getDate("loading_date"));
                route.setTime(rs.getTime("loading_time"));
                routs.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return routs;
    }
}
