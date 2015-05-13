/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.City;
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
public class CityDaoJdbcTest {
    
    public CityDaoJdbcTest() {
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
     * Test of create method, of class CityDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        City city = new City();
        city.setCityId(22);
        city.setStateId(22);
        city.setName("Ciudad de prueba");
        CityDaoJdbc instance = new CityDaoJdbc();
        City result = instance.create(city);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class CityDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        City city = new City();
        city.setCityId(22);
        city.setStateId(22);
        CityDaoJdbc instance = new CityDaoJdbc();
        City result = instance.update(city);
        assertNotNull(result);
    }

    /**
     * Test of delete method, of class CityDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        City city = new City();
        city.setCityId(22);
        city.setStateId(22);
        CityDaoJdbc instance = new CityDaoJdbc();
        instance.delete(city);
    }

    /**
     * Test of findById method, of class CityDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer cityId = 1;
        Integer stateId = 1;
        CityDaoJdbc instance = new CityDaoJdbc();
        City result = instance.findById(cityId, stateId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class CityDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CityDaoJdbc instance = new CityDaoJdbc();
        List<City> result = instance.findAll();
        assertNotNull(result);

    }
    
}
