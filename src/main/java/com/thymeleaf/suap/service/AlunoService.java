package com.thymeleaf.suap.service;

import com.thymeleaf.suap.model.Aluno;
import com.thymeleaf.suap.model.Curso;
import com.thymeleaf.suap.repository.AlunoRepository;
import com.thymeleaf.suap.util.PaginacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;


    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno listarAluno(Long matricula) {
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        return aluno.orElse(null);
    }

    public String deletarAluno(Aluno aluno) {
        alunoRepository.deleteById(aluno.getMatricula());
        return "aluno deletado com sucesso.";
    }

    public void deletarAlunoPorId(Long matricula) {
        alunoRepository.deleteById(matricula);
    }

    public List<Aluno> listarAlunosNome(String nome){
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Aluno> listarAlunosCodigo(Curso curso){
        return alunoRepository.findByCurso(curso);
    }
}
