/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.OrderDetail;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface OrderDetailDao {
        /**
     * Creates a new orderDetail. 
     * @param orderDetail
     * @return 
     */
    OrderDetail create(OrderDetail orderDetail);

    /**
     * Updates an existing orderDetail. OrderDetail id can't be modified.
     * @param orderDetail
     * @return 
     */
    OrderDetail update(OrderDetail orderDetail);

    /**
     * Deletes an existing orderDetail
     * @param orderDetail 
     */
    void delete(OrderDetail orderDetail);

    /**
     * Find a orderDetail by id
     * @param orderDetailId
     * @return 
     */
    OrderDetail findById(Integer orderDetailId);

    /**
     * Returns all the orderDetails in the database
     * @return 
     */
    List<OrderDetail> findAll();
}
