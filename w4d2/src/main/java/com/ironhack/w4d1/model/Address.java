package com.ironhack.w4d1.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String houseCode;

//    No hacer la relación bidireccional a no ser que queramos a ciencia cierta
//    cuidado con hacer esto porque puede oscasionar un bucle infinito
//    @OneToOne(mappedBy = "address")
//    private Teacher teacher;

    public Address() {
    }

    public Address(String street, String houseCode) {
        this.street = street;
        this.houseCode = houseCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseCode='" + houseCode + '\'' +
                '}';
    }
}
