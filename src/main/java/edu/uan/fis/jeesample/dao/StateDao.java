/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.State;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface StateDao {
        /**
     * Creates a new state. 
     * @param state
     * @return 
     */
    State create(State state);

    /**
     * Updates an existing state. State id can't be modified.
     * @param state
     * @return 
     */
    State update(State state);

    /**
     * Deletes an existing state
     * @param state 
     */
    void delete(State state);

    /**
     * Find a state by id
     * @param stateId
     * @return 
     */
    State findById(Integer stateId);

    /**
     * Returns all the states in the database
     * @return 
     */
    List<State> findAll();
}
