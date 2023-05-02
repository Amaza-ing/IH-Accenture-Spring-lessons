package com.ironhack.w4d1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Exam {
    @Id
    private String id;
    private Date startDate;
    private Boolean mandatory;

    public Exam() {
    }

    public Exam(String id, Date startDate, Boolean mandatory) {
        this.id = id;
        this.startDate = startDate;
        this.mandatory = mandatory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }
}
