package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    public void setUp() {
        Course algebra = new Course("Algebra", 150, "B1", "2 weeks", 2);
        courseRepository.save(algebra);
    }

    @AfterEach
    public void tearDown() {
        courseRepository.deleteById("Algebra");
    }

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(7, courseList.size());
    }

    @Test
    public void findById_validId_correctCourse() {
        Optional<Course> course = courseRepository.findById("Math");
        assertTrue(course.isPresent());
        System.out.println(course.get());
        assertEquals(100, course.get().getHours());
    }

    @Test
    public void findById_invalidId_courseNotPresent() {
        Optional<Course> course = courseRepository.findById("Politics");
        assertFalse(course.isPresent());
    }

    @Test
    public void findByHours_validHours_correctCourse() {
        Optional<Course> course = courseRepository.findByHours(90);
        assertTrue(course.isPresent());
        System.out.println(course.get());
        assertEquals("English", course.get().getCourse());
    }

    @Test
    public void findAllByClassroom_validClassroom_courseList() {
        List<Course> courseList = courseRepository.findAllByClassroom("B1");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllByCourseContaining_presentString_courseList() {
        List<Course> courseList = courseRepository.findAllByCourseContaining("p");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllByHoursLessThan_validHours_courseList() {
        List<Course> courseList = courseRepository.findAllByHoursLessThan(150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

}