package com.ironhack.w4d1.service.interfaces;

import com.ironhack.w4d1.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Course getCourseById(String course);
    List<Course> getCourseByClassroomAndHours(String classroom, Optional<Integer> hours);
}