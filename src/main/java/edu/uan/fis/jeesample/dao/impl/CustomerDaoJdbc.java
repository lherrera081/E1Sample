package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.CustomerDao;
import edu.uan.fis.jeesample.dto.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Customer DAO implementation using JDBC
 */
public class CustomerDaoJdbc implements CustomerDao {

    @Override
    public Customer create(Customer customer) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)")) {
                stmt.setInt(1, customer.getCustomerId());
                stmt.setString(2, customer.getName());
                stmt.setString(3, customer.getLastName());
                stmt.setInt(4, customer.getCityId());
                stmt.setInt(5, customer.getStateId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE customer set NAME = ?, LastName= ?, CityId=?, StateId=? where customerId = ?")) {
                stmt.setString(1, customer.getName());
                stmt.setString(2, customer.getLastName());
                stmt.setInt(3, customer.getCityId());
                stmt.setInt(4, customer.getStateId());
                stmt.setInt(5, customer.getCustomerId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM customer where customerId = ?")) {
                stmt.setInt(1, customer.getCustomerId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Customer findById(Integer customerId) {
        Customer customer = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CustomerId, Name, LastName, CityId, StateId FROM customer where CustomerId = ?")) {
                stmt.setInt(1, customerId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    customer = new Customer();
                    customer.setCustomerId(rs.getInt("CustomerId"));
                    customer.setName(rs.getString("Name"));
                    customer.setName(rs.getString("LastName"));
                    customer.setCustomerId(rs.getInt("CityId"));
                    customer.setCustomerId(rs.getInt("StateId"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CustomerId, Name, LastName, CityId, StateId FROM customer")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getInt("CustomerId"));
                    customer.setName(rs.getString("Name"));
                    customer.setName(rs.getString("LastName"));
                    customer.setCustomerId(rs.getInt("CityId"));
                    customer.setCustomerId(rs.getInt("StateId"));
                    customerList.add(customer);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
}
