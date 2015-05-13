package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.StateDao;
import edu.uan.fis.jeesample.dto.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * State DAO implementation using JDBC
 */
public class StateDaoJdbc implements StateDao {

    @Override
    public State create(State state) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO states VALUES(?,?)")) {
                stmt.setInt(1, state.getStateId());
                stmt.setString(2, state.getName());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    @Override
    public State update(State state) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE states set NAME = ? where stateId = ?")) {
                stmt.setString(1, state.getName());
                stmt.setInt(2, state.getStateId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    @Override
    public void delete(State state) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM states where stateId = ?")) {
                stmt.setInt(1, state.getStateId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public State findById(Integer stateId) {
        State state = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT STATEID, NAME FROM states where STATEID = ?")) {
                stmt.setInt(1, stateId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    state = new State();
                    state.setStateId(rs.getInt("STATEID"));
                    state.setName(rs.getString("NAME"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    @Override
    public List<State> findAll() {
        List<State> stateList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT STATEID, NAME FROM states")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    State state = new State();
                    state.setStateId(rs.getInt("STATEID"));
                    state.setName(rs.getString("NAME"));
                    stateList.add(state);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stateList;
    }
}
