package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import edu.uan.fis.jeesample.dao.CategoryDao;
import edu.uan.fis.jeesample.dto.Category;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Category DAO implementation using JDBC
 */
public class CategoryDaoJdbc implements CategoryDao {

    @Override
    public Category create(Category category) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO category VALUES(?,?,?)")) {
                stmt.setInt(1, category.getCategoryId());
                stmt.setString(2, category.getName());
                if (category.getParentCategoryId() == null) {
                    stmt.setNull(3, java.sql.Types.INTEGER);
                } else {
                    stmt.setInt(3, category.getParentCategoryId());
                }
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE category set NAME = ?, ParentCategoryId=? where categoryId = ?")) {
                stmt.setString(1, category.getName());
                if (category.getParentCategoryId() == null) {
                    stmt.setNull(2, java.sql.Types.INTEGER);
                } else {
                    stmt.setInt(2, category.getParentCategoryId());
                }
                stmt.setInt(3, category.getCategoryId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public void delete(Category category) {
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM category where categoryId = ?")) {
                stmt.setInt(1, category.getCategoryId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Category findById(Integer categoryId) {
        Category category = null;
        // Se solicitó implementación de fabrica
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CategoryId, Name, ParentCategoryId FROM category where CategoryId = ?")) {
                stmt.setInt(1, categoryId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    category = new Category();
                    category.setCategoryId(rs.getInt("CategoryId"));
                    category.setName(rs.getString("Name"));
                    category.setParentCategoryId(rs.getInt("ParentCategoryId"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        // Se solicitó implementación de fabrica
        //
        IConnectionFactory connectionFactory = new JdbcConnectionFactory();
        try (Connection conn = connectionFactory.createConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT CategoryId, Name, ParentCategoryId FROM category")) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setCategoryId(rs.getInt("CategoryId"));
                    category.setName(rs.getString("Name"));
                    category.setParentCategoryId(rs.getInt("ParentCategoryId"));
                    categoryList.add(category);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryList;
    }
}
