package com.ironhack.w3d4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacher;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    Sólo utilizar este mapeo si queremos una relación bidireccional
//    Si lo utilizamos, hay que tener cuidado de no ocasionar un error de tipo stackOverflow (bucle infinito)
//    @OneToMany(mappedBy = "teacher")
//    private List<Course> courses;

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

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
//                ", courses=" + courses +
                '}';
    }
}
