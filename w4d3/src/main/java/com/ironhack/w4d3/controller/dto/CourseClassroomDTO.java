package com.ironhack.w4d3.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class CourseClassroomDTO {
    @NotEmpty(message = "Classroom cannot be empty")
    private String classroom;

    public String getClassroom() {
        return classroom;
    }
}
