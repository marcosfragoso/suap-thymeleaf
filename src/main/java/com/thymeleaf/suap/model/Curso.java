package com.thymeleaf.suap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;
@Data
@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name="curso_seq", sequenceName = "curso_seq", allocationSize = 1)
    private Long codigo;

    @Column
    @NotBlank(message = "Informe o nome do curso.")
    @Size(min = 4, max = 50, message = "O nome do curso deve ter no mínimo {min} caracteres e no máximo {max} caracteres.")
    private String nome;

    @Column
    @NotBlank(message = "Informe a área do curso.")
    @Size(min = 4, max = 50, message = "A área do curso deve ter no mínimo {min} caracteres e no máximo {max} caracteres.")
    private String area;
}
