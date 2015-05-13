/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dto;

import java.io.Serializable;

/**
 *
 * @author Luis Herrera
 */
public class Category implements Serializable {
    private String name;
    private Integer categoryId;
    private Integer ParentCategoryId;

    public Integer getParentCategoryId() {
        return ParentCategoryId;
    }

    public void setParentCategoryId(Integer ParentCategoryId) {
        this.ParentCategoryId = ParentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Category == false) {
            return false;
        }
        Category that = (Category) o;
        return that.categoryId.equals(this.categoryId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash += 79 * hash + (this.categoryId != null ? this.categoryId.hashCode() : 0);
        return hash;
    }
}
