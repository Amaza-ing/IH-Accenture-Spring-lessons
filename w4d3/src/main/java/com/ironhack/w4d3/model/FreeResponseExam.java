package com.ironhack.w4d3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class FreeResponseExam extends Exam{
    public FreeResponseExam() {
    }

    public FreeResponseExam(String id, Date startDate, Boolean mandatory) {
        super(id, startDate, mandatory);
    }
}
