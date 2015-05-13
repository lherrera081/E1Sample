package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.OrderDetailDao;
import edu.uan.fis.jeesample.dto.OrderDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * OrderDetail DAO implementation using JDBC
 */
public class OrderDetailDaoJdbc implements OrderDetailDao {

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"ORDERDETAIL\" VALUES(?,?,?,?,?)")) {
                stmt.setInt(1, orderDetail.getOrderDetailId());
                stmt.setInt(2, orderDetail.getQuantity());
                stmt.setDouble(3, orderDetail.getPrice());
                stmt.setInt(4, orderDetail.getProductId());
                stmt.setInt(5, orderDetail.getOrderId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetail;
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE \"ORDERDETAIL\" set Quantity = ?, Price=?, ProductId=?, OrderId=? where orderDetailId = ?")) {
                stmt.setInt(1, orderDetail.getQuantity());
                stmt.setDouble(2, orderDetail.getPrice());
                stmt.setInt(3, orderDetail.getProductId());
                stmt.setInt(4, orderDetail.getOrderId());
                stmt.setInt(5, orderDetail.getOrderDetailId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetail;
    }

    @Override
    public void delete(OrderDetail orderDetail) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM \"ORDERDETAIL\" where orderDetailId = ?")) {
                stmt.setInt(1, orderDetail.getOrderDetailId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public OrderDetail findById(Integer orderDetailId) {
        OrderDetail orderDetail = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT \"ORDERDETAILID\", Quantity, Price, ProductId, \"ORDERID\" FROM \"ORDERDETAIL\" where \"ORDERDETAILID\" = ?")) {
                stmt.setInt(1, orderDetailId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    orderDetail = new OrderDetail();
                    orderDetail.setOrderDetailId(rs.getInt("ORDERDETAILID"));
                    orderDetail.setQuantity(rs.getInt("Quantity"));
                    orderDetail.setPrice(rs.getDouble("Price"));
                    orderDetail.setProductId(rs.getInt("ProductId"));
                    orderDetail.setOrderId(rs.getInt("ORDERID"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT \"ORDERDETAILID\", Quantity, Price, ProductId, OrderId FROM \"ORDERDETAIL\"")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    OrderDetail orderDetail = new OrderDetail();
                     orderDetail.setOrderDetailId(rs.getInt("ORDERDETAILID"));
                    orderDetail.setQuantity(rs.getInt("Quantity"));
                    orderDetail.setPrice(rs.getDouble("Price"));
                    orderDetail.setProductId(rs.getInt("ProductId"));
                    orderDetail.setOrderId(rs.getInt("OrderId"));
                    orderDetailList.add(orderDetail);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetailList;
    }
}
