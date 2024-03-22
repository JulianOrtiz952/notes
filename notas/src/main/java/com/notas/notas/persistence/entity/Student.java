package com.notas.notas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private short value;

    @ManyToOne
    @JoinColumn(name = "id_signature", nullable = false)
    @JsonIgnore
    private Signature signature;
}
