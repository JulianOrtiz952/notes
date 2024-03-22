package com.notas.notas.persistence.dao;

import com.notas.notas.persistence.entity.Student;

import java.util.Optional;

public interface StudentDAO {

    Optional<Student> createStudent(Student student);
    Optional<Student> getStudent(Long id);

}
