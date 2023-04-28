package com.ironhack.w3d5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
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
//    @ToString.Exclude
//    private List<Course> courses;


    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
    }
}
