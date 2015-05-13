/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.OrderDetail;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Herrera
 */
public class OrderDetailDaoJdbcTest {

    public OrderDetailDaoJdbcTest() {
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
     * Test of create method, of class OrderDetailDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(22);
        orderDetail.setOrderId(1);
        orderDetail.setPrice(5000000);
        orderDetail.setProductId(1);
        orderDetail.setQuantity(5);
        OrderDetailDaoJdbc instance = new OrderDetailDaoJdbc();
        OrderDetail result = instance.create(orderDetail);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class OrderDetailDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(22);
        orderDetail.setOrderId(1);
        orderDetail.setPrice(8000000);
        orderDetail.setProductId(1);
        orderDetail.setQuantity(5);
        OrderDetailDaoJdbc instance = new OrderDetailDaoJdbc();
        OrderDetail result = instance.update(orderDetail);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class OrderDetailDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(22);
        OrderDetailDaoJdbc instance = new OrderDetailDaoJdbc();
        instance.delete(orderDetail);
    }

    /**
     * Test of findById method, of class OrderDetailDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer orderDetailId = 1;
        OrderDetailDaoJdbc instance = new OrderDetailDaoJdbc();
        OrderDetail result = instance.findById(orderDetailId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class OrderDetailDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        OrderDetailDaoJdbc instance = new OrderDetailDaoJdbc();
        List<OrderDetail> result = instance.findAll();
        assertNotNull(result);
    }

}
