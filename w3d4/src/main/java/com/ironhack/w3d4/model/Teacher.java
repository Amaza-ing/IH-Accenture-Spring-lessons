package com.ironhack.w3d4.model;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacher;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Teacher() {
    }

    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
