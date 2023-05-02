package com.ironhack.w4d2.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CourseHoursDTO {
    @Max(value = 400, message = "The course cannot be longer than 400 hours")
    @Min(50)
    private  Integer hours;

    public Integer getHours() {
        return hours;
    }
}
