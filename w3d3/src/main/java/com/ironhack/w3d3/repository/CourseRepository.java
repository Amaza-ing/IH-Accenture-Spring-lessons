package com.ironhack.w3d3.repository;

import com.ironhack.w3d3.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

//    JPA QUERY KEYWORDS

    Optional<Course> findByHours(Integer hours);
    List<Course> findAllByClassroom(String classroom);
    List<Course> findAllByCourseContaining(String str);
    List<Course> findAllByHoursLessThan(Integer hours);


//    JPQL

    @Query("SELECT c FROM Course c WHERE c.hours = 150")
    List<Course> findAllWhereHours150();

    @Query("SELECT course, hours FROM Course WHERE hours = 150")
    List<Object[]> findAllWhereHours150JustCourseAndHours();

    @Query("SELECT SUM(c.hours) FROM Course c")
    Integer findHoursSum();

    @Query("SELECT c FROM Course c WHERE c.classroom = 'B1'")
    List<Course> findAllWhereClassroomB1();

    @Query("SELECT c FROM Course c WHERE c.course LIKE '%Algebra%'")
    List<Course> findAllWhereContainingAlgebra();

    @Query("SELECT c FROM Course c WHERE c.hours < 200")
    List<Course> findAllWhereHoursLessThan200();

    @Query("SELECT c FROM Course c WHERE c.classroom = ?1 AND c.hours < ?2")
    List<Course> findAllWhereClassroomAndHoursParams(String classroom, Integer hours);

    @Query("SELECT c FROM Course c WHERE c.classroom = :classroomParam AND c.hours < :hoursParam")
    List<Course> findAllWhereClassroomAndHoursNamedParams(
            @Param("classroomParam") String classroom,
            @Param("hoursParam") Integer hours
    );

    @Query("SELECT c FROM Course c WHERE c.course LIKE CONCAT('%', :strParam, '%')")
    List<Course> findAllWhereContainingStrParam(@Param("strParam") String str);
}
