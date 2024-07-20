package com.thymeleaf.suap.repository;

import com.thymeleaf.suap.model.Aluno;
import com.thymeleaf.suap.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
    List<Aluno> findByCurso(Curso curso);
}
