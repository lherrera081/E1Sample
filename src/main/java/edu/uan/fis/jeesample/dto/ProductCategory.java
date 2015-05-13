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
public class ProductCategory implements Serializable {
    private Integer productId;
    private Integer categoryId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if((o instanceof ProductCategory) == false)
            return false;
        ProductCategory that = (ProductCategory) o;
        return that.productId.equals(this.productId) && that.categoryId.equals(this.categoryId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.categoryId != null ? this.categoryId.hashCode() : 0);
        hash = 79 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        return hash;
    }
}
