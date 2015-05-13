package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.CityDao;
import edu.uan.fis.jeesample.dto.City;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * City DAO implementation using JDBC
 */
public class CityDaoJdbc implements CityDao {

    @Override
    public City create(City city) {
        // Se solicitó implementar una fabrica.
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO city VALUES(?,?,?)")) {
                stmt.setInt(1, city.getCityId());
                stmt.setInt(2, city.getStateId());
                stmt.setString(3, city.getName());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }

    @Override
    public City update(City city) {
        // Se solicitó implementar una fabrica.
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE city set NAME = ? where cityId = ? and stateId = ?")) {
                stmt.setString(1, city.getName());
                stmt.setInt(2, city.getCityId());
                stmt.setInt(3, city.getStateId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }

    @Override
    public void delete(City city) {
        // Se solicitó implementar una fabrica.
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM city where cityId = ? and stateId = ?")) {
                stmt.setInt(1, city.getCityId());
                stmt.setInt(2, city.getStateId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public City findById(Integer cityId, Integer stateId) {
        City city = null;
        // Se solicitó implementar una fabrica.
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CITYID, STATEID, NAME FROM city where CITYID = ? AND STATEID = ?")) {
                stmt.setInt(1, cityId);
                stmt.setInt(2, stateId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    city = new City();
                    city.setCityId(rs.getInt("CITYID"));
                    city.setCityId(rs.getInt("STATEID"));
                    city.setName(rs.getString("NAME"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }

    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();
        // Se solicitó implementar una fabrica.
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CITYID, STATEID, NAME FROM city")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    City city = new City();
                    city.setCityId(rs.getInt("CITYID"));
                    city.setCityId(rs.getInt("STATEID"));
                    city.setName(rs.getString("NAME"));
                    cityList.add(city);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cityList;
    }
}
