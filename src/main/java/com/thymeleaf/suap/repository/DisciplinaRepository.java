package com.thymeleaf.suap.repository;

import com.thymeleaf.suap.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
