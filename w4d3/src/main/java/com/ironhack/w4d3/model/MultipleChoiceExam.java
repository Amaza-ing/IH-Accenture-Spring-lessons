package com.ironhack.w4d3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MultipleChoiceExam extends Exam{
    private Integer numberOfChoices;

    public MultipleChoiceExam() {
    }

    public MultipleChoiceExam(String id, Date startDate, Boolean mandatory, Integer numberOfChoices) {
        super(id, startDate, mandatory);
        this.numberOfChoices = numberOfChoices;
    }

    public Integer getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(Integer numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }
}
