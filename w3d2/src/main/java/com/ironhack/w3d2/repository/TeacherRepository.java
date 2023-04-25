package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                              //JpaRepository<Modelo, tipo de dato de clave primaria del modelo>
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
