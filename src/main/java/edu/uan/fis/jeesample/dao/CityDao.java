/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.City;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface CityDao {
        /**
     * Creates a new city. 
     * @param city
     * @return 
     */
    City create(City city);

    /**
     * Updates an existing city. City id can't be modified.
     * @param city
     * @return 
     */
    City update(City city);

    /**
     * Deletes an existing city
     * @param city 
     */
    void delete(City city);

    /**
     * Find a city by id
     * @param cityId
     * @return 
     */
    City findById(Integer cityId, Integer stateId);

    /**
     * Returns all the citys in the database
     * @return 
     */
    List<City> findAll();
}
