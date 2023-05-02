package com.ironhack.w4d1.controller.interfaces;

import com.ironhack.w4d1.model.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ICourseController {
    List<Course> getAllCourses();
    Course getCourseById(String course);
    List<Course> getCourseByHoursLessThan(Integer hours);
    List<Course> getCourseByClassroomAndHours(String classroom, Optional<Integer> hours);
}
