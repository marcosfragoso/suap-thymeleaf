package com.thymeleaf.suap.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Matricula")
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

    public Matricula(){}

    public Matricula(MatriculaID id, Aluno aluno, Disciplina disciplina, String periodo) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }

    public MatriculaID getId() {
        return id;
    }

    public void setId(MatriculaID id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id) && Objects.equals(aluno, matricula.aluno) && Objects.equals(disciplina, matricula.disciplina) && Objects.equals(periodo, matricula.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aluno, disciplina, periodo);
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
