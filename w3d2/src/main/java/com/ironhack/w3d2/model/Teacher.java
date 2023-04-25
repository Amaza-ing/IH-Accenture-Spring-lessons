package com.ironhack.w3d2.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "teacher") // En caso de que la tabla se llame de manera diferente a la clase
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id") // En caso de que la propiedad se llame de manera diferente al campo
    private Integer id;

//    @Column(name = "teacher")  // En caso de que la propiedad se llame de manera diferente al campo
    private String teacher;

    public Teacher() {
    }

    public Teacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
