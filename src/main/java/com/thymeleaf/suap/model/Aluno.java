package com.thymeleaf.suap.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    @SequenceGenerator(name= "aluno_seq",sequenceName= "aluno_seq", allocationSize = 1)
    private Long matricula;

    @Column
    @NotNull
    private String nome;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cod_curso")
    private Curso curso;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> disciplinas;


}
