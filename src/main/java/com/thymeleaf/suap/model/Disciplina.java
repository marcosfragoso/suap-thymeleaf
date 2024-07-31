package com.thymeleaf.suap.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Disciplina")
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
    @SequenceGenerator(name="disciplina_seq", sequenceName = "disciplina_seq", allocationSize = 1)
    private Long codigo;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private int cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "cod_prof")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "cod_curso")
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private List<Matricula> alunos;
}
