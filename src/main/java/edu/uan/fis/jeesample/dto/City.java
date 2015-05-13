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
public class City implements Serializable {
    private Integer stateId;
    private Integer cityId;
    private String name;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof City == false) {
            return false;
        }
        City that = (City) o;
        return that.cityId.equals(this.cityId)&&that.stateId.equals(this.stateId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash += 79 * hash + (this.cityId != null ? this.cityId.hashCode() : 0);
        hash += 79 * hash + (this.stateId != null ? this.stateId.hashCode() : 0);
        return hash;
    }
}
