/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Category;
import java.util.List;

/**
 *
 * @author Luis Herrera
 */
public interface CategoryDao {
        /**
     * Creates a new category. 
     * @param category
     * @return 
     */
    Category create(Category category);

    /**
     * Updates an existing category. Category id can't be modified.
     * @param category
     * @return 
     */
    Category update(Category category);

    /**
     * Deletes an existing category
     * @param category 
     */
    void delete(Category category);

    /**
     * Find a category by id
     * @param categoryId
     * @return 
     */
    Category findById(Integer categoryId);

    /**
     * Returns all the categorys in the database
     * @return 
     */
    List<Category> findAll();
}
