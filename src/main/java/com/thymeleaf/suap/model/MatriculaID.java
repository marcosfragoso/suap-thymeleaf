package com.thymeleaf.suap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "matricula_aluno")
    private Long matricula_aluno;

    @Column(name = "cod_disciplina")
    private Long cod_disciplina;

    @Column(name = "periodo_matricula")
    private String periodo_matricula;
}
