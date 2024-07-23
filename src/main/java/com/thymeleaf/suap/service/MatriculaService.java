package com.thymeleaf.suap.service;

import com.thymeleaf.suap.model.Aluno;
import com.thymeleaf.suap.model.Disciplina;
import com.thymeleaf.suap.model.Matricula;
import com.thymeleaf.suap.model.MatriculaID;
import com.thymeleaf.suap.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Transactional(readOnly = true)
    public List<Matricula> listarMatriculas(){
        return matriculaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<Matricula> cadastrarMatricula(List<Matricula> matriculas) {
        return matriculaRepository.saveAll(matriculas);
    }

    @Transactional(readOnly = false)
    public Matricula atualizarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Transactional(readOnly = true)
    public Matricula listarMatricula(MatriculaID matriculaID) {
        Matricula matricula = (Matricula) matriculaRepository.findById(matriculaID).orElse(null);
        return matricula;
    }

    @Transactional(readOnly = false)
    public String deletarMatricula(Matricula matricula) {
        MatriculaID matriculaID = matricula.getId();
        matriculaRepository.deleteById(matriculaID);
        return "Matricula " + matricula + " deletado com sucesso";
    }

    @Transactional(readOnly = true)
    public Map<String,List<Disciplina>> buscarDisciplinasporPeriodo(Aluno aluno){
        List<Matricula> alunoMatricula = matriculaRepository.findByAluno(aluno);

        Map<String, List<Disciplina>> disciplinasPorPeriodo = alunoMatricula.stream()
                .collect(Collectors.groupingBy(Matricula::getPeriodo,
                        Collectors.mapping(Matricula::getDisciplina, Collectors.toList())));
        return disciplinasPorPeriodo;
    }

    @Transactional(readOnly = false)
    public String deletarMatriculaID(MatriculaID matriculaID) {
        matriculaRepository.deleteById(matriculaID);
        return "Matricula de codigo " + matriculaID + " deletada com sucesso";
    }
}
