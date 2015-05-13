/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.ProductCategory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ProductCategoryDaoJdbcTest {
    
    public ProductCategoryDaoJdbcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductCategoryDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(22);
        productCategory.setProductId(22);
        ProductCategoryDaoJdbc instance = new ProductCategoryDaoJdbc();
        ProductCategory result = instance.create(productCategory);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class ProductCategoryDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(22);
        productCategory.setProductId(22);
        ProductCategoryDaoJdbc instance = new ProductCategoryDaoJdbc();
        ProductCategory result = instance.update(productCategory);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class ProductCategoryDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(22);
        productCategory.setProductId(22);
        ProductCategoryDaoJdbc instance = new ProductCategoryDaoJdbc();
        instance.delete(productCategory);
    }

    /**
     * Test of findById method, of class ProductCategoryDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer productId = 1;
        Integer categoryId = 1;
        ProductCategoryDaoJdbc instance = new ProductCategoryDaoJdbc();
        ProductCategory result = instance.findById(productId, categoryId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class ProductCategoryDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ProductCategoryDaoJdbc instance = new ProductCategoryDaoJdbc();
        List<ProductCategory> result = instance.findAll();
        assertNotNull(result);
    }
    
}
