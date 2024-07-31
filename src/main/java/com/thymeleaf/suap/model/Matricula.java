package com.thymeleaf.suap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Matricula")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    @EmbeddedId
    private MatriculaID id;

    @ManyToOne
    @MapsId("matricula_aluno")
    @JoinColumn(name = "matricula_aluno")
    private Aluno aluno;

    @ManyToOne
    @MapsId("cod_disciplina")
    @JoinColumn(name = "cod_disciplina")
    private Disciplina disciplina;

    @Column(name = "periodo_matricula", insertable = false, updatable = false)
    private String periodo;
}
