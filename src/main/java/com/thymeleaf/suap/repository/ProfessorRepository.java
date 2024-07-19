package com.thymeleaf.suap.repository;

import com.thymeleaf.suap.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
