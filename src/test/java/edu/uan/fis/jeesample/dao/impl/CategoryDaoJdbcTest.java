/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Category;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Luis Herrera
 */
public class CategoryDaoJdbcTest extends TestCase {

    public CategoryDaoJdbcTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of create method, of class CategoryDaoJdbc.
     */
    public void testCreate() {
        System.out.println("create");
        Category category = new Category();
        category.setCategoryId(22);
        category.setName("Test of category - Insert");
        CategoryDaoJdbc instance = new CategoryDaoJdbc();
//        Category expResult = null;
        Category result = instance.create(category);
        assertEquals(category, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CategoryDaoJdbc.
     */
    public void testUpdate() {
        System.out.println("update");
        Category category = new Category();
        category.setCategoryId(22);
        category.setName("Test of category - update");;
        CategoryDaoJdbc instance = new CategoryDaoJdbc();
        Category result = instance.update(category);
        assertEquals(category, result);
    }

    /**
     * Test of delete method, of class CategoryDaoJdbc.
     */
    public void testDelete() {
        System.out.println("delete");
        Category category = new Category();
        category.setCategoryId(22);
        CategoryDaoJdbc instance = new CategoryDaoJdbc();
        instance.delete(category);
    }

    /**
     * Test of findById method, of class CategoryDaoJdbc.
     */
    public void testFindById() {
        System.out.println("findById");
        Integer categoryId = 1;
        CategoryDaoJdbc instance = new CategoryDaoJdbc();
        Category result = instance.findById(categoryId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class CategoryDaoJdbc.
     */
    public void testFindAll() {
        System.out.println("findAll");
        CategoryDaoJdbc instance = new CategoryDaoJdbc();
        List<Category> result = instance.findAll();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
