package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.ProductDao;
import edu.uan.fis.jeesample.dto.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Product DAO implementation using JDBC
 */
public class ProductDaoJdbc implements ProductDao {

    @Override
    public Product create(Product product) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO product VALUES(?,?,?)")) {
                stmt.setInt(1, product.getProductId());
                stmt.setString(2, product.getName());
                stmt.setDouble(3, product.getPrice());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE product set NAME = ?, Price=? where productId = ?")) {
                stmt.setString(1, product.getName());
                stmt.setDouble(2, product.getPrice());
                stmt.setInt(3, product.getProductId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return product;
    }

    @Override
    public void delete(Product product) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM product where productId = ?")) {
                stmt.setInt(1, product.getProductId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Product findById(Integer productId) {
        Product product = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT PRODUCTID, NAME, Price FROM product where PRODUCTID = ?")) {
                stmt.setInt(1, productId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    product = new Product();
                    product.setProductId(rs.getInt("PRODUCTID"));
                    product.setName(rs.getString("NAME"));
                    product.setPrice(rs.getDouble("Price"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);   
            return null;
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT PRODUCTID, NAME, Price FROM product")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Product product = new Product();
                    product.setProductId(rs.getInt("PRODUCTID"));
                    product.setName(rs.getString("NAME"));
                    product.setPrice(rs.getDouble("Price"));
                    productList.add(product);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return productList;
    }
}
