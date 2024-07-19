package com.thymeleaf.suap.service;


import com.thymeleaf.suap.model.Professor;
import com.thymeleaf.suap.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor listarProfessor(Long matricula) {
        Optional<Professor> professor = professorRepository.findById(matricula);
        return professor.orElse(null);
    }

    public String deletarProfessor(Professor professor) {
        professorRepository.deleteById(professor.getMatricula());
        return "Professor deletado com sucesso.";
    }

    public void deletarProfessorPorId(Long matricula) {
        professorRepository.deleteById(matricula);
    }
}
