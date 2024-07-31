package com.thymeleaf.suap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoMatriculaDTO {
    private Long matricula;
    private List<Disciplina> disciplinas;
    private String periodo;
}
