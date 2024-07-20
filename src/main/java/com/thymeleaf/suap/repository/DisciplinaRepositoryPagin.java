package com.thymeleaf.suap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thymeleaf.suap.model.Disciplina;

public interface DisciplinaRepositoryPagin extends JpaRepository<Disciplina, Long> {

    Page<Disciplina> findAll(Pageable pageable);
}
