/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Customer;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface CustomerDao {
        /**
     * Creates a new customer. 
     * @param customer
     * @return 
     */
    Customer create(Customer customer);

    /**
     * Updates an existing customer. Customer id can't be modified.
     * @param customer
     * @return 
     */
    Customer update(Customer customer);

    /**
     * Deletes an existing customer
     * @param customer 
     */
    void delete(Customer customer);

    /**
     * Find a customer by id
     * @param customerId
     * @return 
     */
    Customer findById(Integer customerId);

    /**
     * Returns all the customers in the database
     * @return 
     */
    List<Customer> findAll();
}
