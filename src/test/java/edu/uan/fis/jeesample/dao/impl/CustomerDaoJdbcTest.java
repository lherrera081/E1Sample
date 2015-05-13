/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Customer;
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
public class CustomerDaoJdbcTest {
    
    public CustomerDaoJdbcTest() {
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
     * Test of create method, of class CustomerDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Customer customer = new Customer(); 
        customer.setCustomerId(22);
        customer.setCityId(1);
        customer.setStateId(1);
        customer.setName("Nombre de prueba");
        customer.setLastName("Apellido de prueba");
        CustomerDaoJdbc instance = new CustomerDaoJdbc();
        Customer result = instance.create(customer);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class CustomerDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Customer customer = new Customer(); 
        customer.setCustomerId(22);
        customer.setCityId(1);
        customer.setStateId(1);
        customer.setName("Nombre de prueba");
        customer.setLastName("Apellido de prueba");
        CustomerDaoJdbc instance = new CustomerDaoJdbc();
        Customer result = instance.update(customer);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class CustomerDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Customer customer = new Customer(); 
        customer.setCustomerId(22);
        CustomerDaoJdbc instance = new CustomerDaoJdbc();
        instance.delete(customer);
    }

    /**
     * Test of findById method, of class CustomerDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer customerId = 1;
        CustomerDaoJdbc instance = new CustomerDaoJdbc();
        Customer result = instance.findById(customerId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class CustomerDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CustomerDaoJdbc instance = new CustomerDaoJdbc();
        List<Customer> result = instance.findAll();
        assertNotNull(result);
    }
    
}
