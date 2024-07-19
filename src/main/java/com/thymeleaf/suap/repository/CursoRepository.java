package com.thymeleaf.suap.repository;


import com.thymeleaf.suap.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}