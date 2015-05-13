/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.State;
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
public class StateDaoJdbcTest {
    
    public StateDaoJdbcTest() {
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
     * Test of create method, of class StateDaoJdbc.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        State state = new State();
        state.setStateId(22);
        state.setName("Ciudad de test");
        StateDaoJdbc instance = new StateDaoJdbc();
        State result = instance.create(state);
        assertNotNull(result);
    }

    /**
     * Test of update method, of class StateDaoJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        State state = new State();
        state.setStateId(22);
        state.setName("Ciudad de test");
        StateDaoJdbc instance = new StateDaoJdbc();
        State result = instance.update(state);
        assertNotNull(result);

    }

    /**
     * Test of delete method, of class StateDaoJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        State state = new State();
        state.setStateId(22);
        StateDaoJdbc instance = new StateDaoJdbc();
        instance.delete(state);
    }

    /**
     * Test of findById method, of class StateDaoJdbc.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer stateId = 1;
        StateDaoJdbc instance = new StateDaoJdbc();
        State result = instance.findById(stateId);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class StateDaoJdbc.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        StateDaoJdbc instance = new StateDaoJdbc();
        List<State> result = instance.findAll();
        assertNotNull(result);
    }
    
}
