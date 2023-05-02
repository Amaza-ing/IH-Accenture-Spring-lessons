package com.ironhack.w4d1.repository;

import com.ironhack.w4d1.model.Course;
import com.ironhack.w4d1.model.Teacher;
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

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    public void setUp() {
        Optional<Teacher> teacher = teacherRepository.findById(1);
        Course algebra = new Course("Algebra", 150, "B1", "2 weeks", teacher.get());
        courseRepository.save(algebra);
    }

    @AfterEach
    public void tearDown() {
        courseRepository.deleteById("Algebra");
    }


    //    ******************************************************************************
    //    ************************************* JPA ************************************
    //    ******************************************************************************

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


    //    ******************************************************************************
    //    ************************************ JPQL ************************************
    //    ******************************************************************************


    @Test
    public void findAllWhereHours150__courseList() {
        List<Course> courseList = courseRepository.findAllWhereHours150();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllWhereHours150JustCourseAndHours__courseList() {
        List<Object[]> courseList = courseRepository.findAllWhereHours150JustCourseAndHours();
        for (Object[] elem : courseList) {
            for  (Object data : elem) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
        assertEquals(3, courseList.size());
    }

    @Test
    public void findHourSum__hoursSum() {
        Integer hoursSum = courseRepository.findHoursSum();
        System.out.println(hoursSum);
        assertEquals(960, hoursSum);
    }

    @Test
    public void findAllWhereClassroomB1__courseList() {
        List<Course> courseList = courseRepository.findAllWhereClassroomB1();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllWhereContainingAlgebra__courseList() {
        List<Course> courseList = courseRepository.findAllWhereContainingAlgebra();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    public void findAllWhereHoursLessThan200__courseList() {
        List<Course> courseList = courseRepository.findAllWhereHoursLessThan200();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    public void findAllWhereClassroomAndHoursParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllWhereClassroomAndHoursNamedParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursNamedParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllWhereContainingStrParam_validParam_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereContainingStrParam("Algebra");
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }


    //    ******************************************************************************
    //    ********************************* NATIVE SQL *********************************
    //    ******************************************************************************

    @Test
    void nativeFindAllWhereHours150__courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHours150();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindHoursSum__HoursSum() {
        Integer hoursSum = courseRepository.nativeFindHoursSum();
        System.out.println(hoursSum);
        assertEquals(960, hoursSum);
    }

    @Test
    void nativeFindAllWhereClassroomB1__courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomB1();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereContainingAlgebra__courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereContainingAlgebra();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    void nativeFindAllWhereHoursLessThan200__courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHoursLessThan200();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    void nativeFindAllWhereClassroomAndHoursParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomAndHoursParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereClassroomAndHoursNamedParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomAndHoursNamedParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereContainingStrParam_validParam_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereContainingStrParam("Algebra");
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }
}