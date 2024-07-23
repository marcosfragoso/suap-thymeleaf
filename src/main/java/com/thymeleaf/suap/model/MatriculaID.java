package com.thymeleaf.suap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MatriculaID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "matricula_aluno")
    private Long matricula_aluno;

    @Column(name = "cod_disciplina")
    private Long cod_disciplina;

    @Column(name = "periodo_matricula")
    private String periodo_matricula;


    private MatriculaID() {}

    public MatriculaID(Long matricula_aluno, Long cod_disciplina, String periodo_matricula) {
        super();
        this.matricula_aluno = matricula_aluno;
        this.cod_disciplina = cod_disciplina;
        this.periodo_matricula = periodo_matricula;
    }
}
