package com.notas.notas.controller.dto;

import com.notas.notas.persistence.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureDTO {

    private Long id;
    private String signature;
    private List<Student> studentList = new ArrayList<>();

}
