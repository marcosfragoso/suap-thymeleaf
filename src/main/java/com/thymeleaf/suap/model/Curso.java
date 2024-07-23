package com.thymeleaf.suap.model;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(codigo, curso.codigo) && Objects.equals(nome, curso.nome) && Objects.equals(area, curso.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, area);
    }
}
