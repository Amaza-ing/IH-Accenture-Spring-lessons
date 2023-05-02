package com.ironhack.w4d2.controller.interfaces;

import com.ironhack.w4d2.model.Teacher;

import java.util.List;

public interface ITeacherController {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
}
