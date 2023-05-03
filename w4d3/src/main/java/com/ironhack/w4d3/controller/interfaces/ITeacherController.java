package com.ironhack.w4d3.controller.interfaces;

import com.ironhack.w4d3.model.Teacher;

import java.util.List;

public interface ITeacherController {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
}
