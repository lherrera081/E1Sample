/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Order;
import java.sql.Date;
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
public class OrderDaoJdbcTest {
    
    public OrderDaoJdbcTest() {
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
     * Test of create method, of class OrderDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Order order = new Order();
        order.setOrderId(22);
        order.setCustomerId(1);
        order.setDate(new Date(2015, 05, 25));
        order.setSalesAmount(5000000);
        OrderDaoJdbc instance = new OrderDaoJdbc();
        Order result = instance.create(order);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class OrderDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Order order = new Order();
        order.setOrderId(22);
        order.setCustomerId(1);
        order.setDate(new Date(2015, 05, 25));
        order.setSalesAmount(4000000);
        OrderDaoJdbc instance = new OrderDaoJdbc();
        Order result = instance.update(order);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class OrderDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Order order = new Order();
        order.setOrderId(22);
        OrderDaoJdbc instance = new OrderDaoJdbc();
        instance.delete(order);
    }

    /**
     * Test of findById method, of class OrderDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer orderId = 1;
        OrderDaoJdbc instance = new OrderDaoJdbc();
        Order result = instance.findById(orderId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class OrderDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        OrderDaoJdbc instance = new OrderDaoJdbc();
        List<Order> result = instance.findAll();
        assertNotNull(result);
    }
    
}
