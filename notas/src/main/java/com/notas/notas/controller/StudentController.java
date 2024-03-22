package com.notas.notas.controller;

import com.notas.notas.controller.dto.StudentDTO;
import com.notas.notas.persistence.entity.Student;
import com.notas.notas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.postStudent(studentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){ return ResponseEntity.ok(studentService.getStudent(id));}

}
