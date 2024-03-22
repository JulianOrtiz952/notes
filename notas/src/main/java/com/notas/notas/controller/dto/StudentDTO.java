package com.notas.notas.controller.dto;

import com.notas.notas.persistence.entity.Signature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private Long id;
    private String name;
    private short value;
    private Signature signature;

}
