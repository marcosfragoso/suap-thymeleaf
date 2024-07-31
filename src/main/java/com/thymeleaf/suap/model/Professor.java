package com.thymeleaf.suap.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "Professor")
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_seq")
    @SequenceGenerator(name="professor_seq", sequenceName = "professor_seq", allocationSize = 1)
    private Long matricula;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String area;
}
