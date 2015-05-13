package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.ProductCategoryDao;
import edu.uan.fis.jeesample.dto.ProductCategory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * ProductCategory DAO implementation using JDBC
 */
public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO productCategory VALUES(?,?)")) {
                stmt.setInt(1, productCategory.getCategoryId());
                stmt.setInt(2, productCategory.getProductId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productCategory;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return productCategory;
    }

    @Override
    public void delete(ProductCategory productCategory) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM productCategory where CategoryId = ? AND ProductId = ?")) {
                stmt.setInt(1, productCategory.getProductId());
                stmt.setInt(2, productCategory.getCategoryId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ProductCategory findById(Integer productId, Integer categoryId) {
        ProductCategory productCategory = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT PRODUCTID, CategoryId FROM productCategory where CategoryId = ? AND ProductId = ?")) {
                stmt.setInt(1, categoryId);
                stmt.setInt(2, productId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    productCategory = new ProductCategory();
                    productCategory.setProductId(rs.getInt("PRODUCTID"));
                    productCategory.setCategoryId(rs.getInt("CategoryId"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT PRODUCTID, CategoryId FROM productCategory")) {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    ProductCategory productCategory = new ProductCategory();
                    productCategory.setProductId(rs.getInt("PRODUCTID"));
                    productCategory.setCategoryId(rs.getInt("CategoryId"));
                    productCategoryList.add(productCategory);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productCategoryList;
    }
}
