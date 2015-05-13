/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dto;

/**
 *
 * @author Luis Herrera
 */
public class Customer {
    private Integer customerId;
    private Integer cityId;
    private Integer stateId;
    private String name;
    private String lastName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Customer == false) {
            return false;
        }
        Customer that = (Customer) o;
        return that.customerId.equals(this.customerId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash += 79 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash += 79 * hash + (this.cityId != null ? this.cityId.hashCode() : 0);
        hash += 79 * hash + (this.stateId != null ? this.stateId.hashCode() : 0);
        hash += 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        return hash;
    }
}
