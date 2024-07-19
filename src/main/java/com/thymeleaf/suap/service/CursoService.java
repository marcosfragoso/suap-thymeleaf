package com.thymeleaf.suap.service;


import com.thymeleaf.suap.model.Curso;
import com.thymeleaf.suap.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso listarCurso(Long codigo) {
        Optional<Curso> curso = cursoRepository.findById(codigo);
        return curso.orElse(null);
    }

    public String deletarCurso(Curso curso) {
        cursoRepository.deleteById(curso.getCodigo());
        return "Curso deletado com sucesso.";
    }

    public void deletarCursoPorId(Long codigo) {
        cursoRepository.deleteById(codigo);
    }
}