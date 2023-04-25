package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void findAll_teachers_teacherList() {
        List<Teacher> teacherList = teacherRepository.findAll();
        System.out.println(teacherList);
        assertEquals(3, teacherList.size());
    }

    @Test
    public void findById_validId_correctTeacher() {
        Optional<Teacher> teacher = teacherRepository.findById(1);
        assertTrue(teacher.isPresent());
        System.out.println(teacher.get());
        assertEquals("Alberto García", teacher.get().getTeacher());
    }

    @Test
    public void findById_invalidId_teacherNotPresent() {
        Optional<Teacher> teacher = teacherRepository.findById(999);
        assertTrue(teacher.isEmpty());
    }

}