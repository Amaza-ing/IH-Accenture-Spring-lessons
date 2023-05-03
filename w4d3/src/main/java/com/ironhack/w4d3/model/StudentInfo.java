package com.ironhack.w4d3.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentInfo {
    private String street;
    private Integer houseNumber;
    private String telephone;

    public StudentInfo(String street, Integer houseNumber, String telephone) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.telephone = telephone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
