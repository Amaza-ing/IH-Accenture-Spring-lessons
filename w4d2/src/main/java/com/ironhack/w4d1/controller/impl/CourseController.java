package com.ironhack.w4d1.controller.impl;

import com.ironhack.w4d1.controller.interfaces.ICourseController;
import com.ironhack.w4d1.model.Course;
import com.ironhack.w4d1.repository.CourseRepository;
import com.ironhack.w4d1.service.interfaces.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController implements ICourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ICourseService courseService;


    //  ******************************************************  GET  ******************************************************

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable(name = "course") String course) {
        return courseService.getCourseById(course);
    }

    @GetMapping("/courses/hours")
    public List<Course> getCourseByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCourseByClassroomAndHours(
        @RequestParam(defaultValue = "A1") String classroom,
        @RequestParam Optional<Integer> hours
    ) {
        return courseService.getCourseByClassroomAndHours(classroom, hours);
    }


    //  *****************************************************  POST  ******************************************************

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid Course course) {
        courseRepository.save(course);
    }
}
