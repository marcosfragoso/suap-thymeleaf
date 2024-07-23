package com.thymeleaf.suap.model;

import java.util.List;

public class AlunoMatriculaDTO {
    private Long matricula;
    private List<Disciplina> disciplinas;
    private String periodo;

    public AlunoMatriculaDTO(Long matricula, List<Disciplina> disciplinas, String periodo) {
        this.matricula = matricula;
        this.disciplinas = disciplinas;
        this.periodo = periodo;
    }

    public AlunoMatriculaDTO() {
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
