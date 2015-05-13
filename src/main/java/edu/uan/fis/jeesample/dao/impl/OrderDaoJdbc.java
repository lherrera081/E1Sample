package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.OrderDao;
import edu.uan.fis.jeesample.dto.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Order DAO implementation using JDBC
 */
public class OrderDaoJdbc implements OrderDao {

    @Override
    public Order create(Order order) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"ORDER\" VALUES(?,?,?,?)")) {
                stmt.setInt(1, order.getOrderId());
                stmt.setInt(2, order.getCustomerId());
                stmt.setDate(3, order.getDate());
                stmt.setInt(4, order.getSalesAmount());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public Order update(Order order) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE \"ORDER\" set CustomerId = ?, Date=?, SalesAmount =? where orderId = ?")) {
                stmt.setInt(1, order.getCustomerId());
                stmt.setDate(2, order.getDate());
                stmt.setInt(3, order.getSalesAmount());
                stmt.setInt(4, order.getOrderId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public void delete(Order order) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM \"ORDER\" where orderId = ?")) {
                stmt.setInt(1, order.getOrderId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Order findById(Integer orderId) {
        Order order = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT OrderId, CustomerId, Date, SalesAmount FROM \"ORDER\" where OrderId = ?")) {
                stmt.setInt(1, orderId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("OrderId"));
                    order.setCustomerId(rs.getInt("CustomerId"));
                    order.setDate(rs.getDate("Date"));
                    order.setSalesAmount(rs.getInt("SalesAmount"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT OrderId, CustomerId, Date, SalesAmount FROM \"ORDER\"")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Order order = new Order();
                    order.setOrderId(rs.getInt("OrderId"));
                    order.setCustomerId(rs.getInt("CustomerId"));
                    order.setDate(rs.getDate("Date"));
                    order.setSalesAmount(rs.getInt("SalesAmount"));
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }
}
