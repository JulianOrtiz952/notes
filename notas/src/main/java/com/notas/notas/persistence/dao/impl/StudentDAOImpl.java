package com.notas.notas.persistence.dao.impl;

import com.notas.notas.persistence.dao.StudentDAO;
import com.notas.notas.persistence.entity.Student;
import com.notas.notas.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> createStudent(Student student) {
        return Optional.of(studentRepository.save(student));
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }
}
