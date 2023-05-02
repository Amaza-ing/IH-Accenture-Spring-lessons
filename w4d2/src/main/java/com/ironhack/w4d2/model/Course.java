package com.ironhack.w4d2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String course;

    @Max(value = 400, message = "The course cannot be longer than 400 hours")
    @Min(50)
    private Integer hours;

    @NotEmpty(message = "Classroom cannot be empty")
    private String classroom;

    private String vacations;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
