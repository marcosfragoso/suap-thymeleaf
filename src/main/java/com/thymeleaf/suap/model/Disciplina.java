package com.thymeleaf.suap.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Disciplina")
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return cargaHoraria == that.cargaHoraria && Objects.equals(codigo, that.codigo) && Objects.equals(nome, that.nome) && Objects.equals(professor, that.professor) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, cargaHoraria, professor, curso);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", professor=" + professor +
                ", curso=" + curso +
                '}';
    }
}
