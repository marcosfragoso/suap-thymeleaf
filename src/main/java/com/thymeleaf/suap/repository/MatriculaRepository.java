package com.thymeleaf.suap.repository;

import com.thymeleaf.suap.model.Aluno;
import com.thymeleaf.suap.model.Matricula;
import com.thymeleaf.suap.model.MatriculaID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaID> {
    List<Matricula> findByAluno(Aluno aluno);
}
