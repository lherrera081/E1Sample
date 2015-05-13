/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Order;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface OrderDao {
        /**
     * Creates a new order. 
     * @param order
     * @return 
     */
    Order create(Order order);

    /**
     * Updates an existing order. Order id can't be modified.
     * @param order
     * @return 
     */
    Order update(Order order);

    /**
     * Deletes an existing order
     * @param order 
     */
    void delete(Order order);

    /**
     * Find a order by id
     * @param orderId
     * @return 
     */
    Order findById(Integer orderId);

    /**
     * Returns all the orders in the database
     * @return 
     */
    List<Order> findAll();
}
