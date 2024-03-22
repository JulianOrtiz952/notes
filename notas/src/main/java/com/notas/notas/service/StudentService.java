package com.notas.notas.service;

import com.notas.notas.controller.dto.StudentDTO;
import com.notas.notas.persistence.entity.Student;
import com.notas.notas.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student postStudent(StudentDTO studentDTO){
        if(studentDTO.getName().isBlank()) throw new RuntimeException("");
        if(studentDTO.getValue()>10||studentDTO.getValue()<0) throw new RuntimeException("value out of context");
        return studentRepository.save(Student.builder().id(studentDTO.getId()).name(studentDTO.getName()).value(studentDTO.getValue()).signature(studentDTO.getSignature()).build());
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow();
    }



}
