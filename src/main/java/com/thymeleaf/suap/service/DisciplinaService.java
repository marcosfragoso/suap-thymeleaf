package com.thymeleaf.suap.service;


import com.thymeleaf.suap.model.Disciplina;
import com.thymeleaf.suap.repository.DisciplinaRepository;
import com.thymeleaf.suap.repository.DisciplinaRepositoryPagin;
import com.thymeleaf.suap.util.PaginacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaRepositoryPagin disciplinaRepositoryPagin;

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina listarDisciplina(Long codigo) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(codigo);
        return disciplina.orElse(null);
    }

    public String deletarDisciplina(Disciplina disciplina) {
        disciplinaRepository.deleteById(disciplina.getCodigo());
        return "disciplina deletado com sucesso.";
    }

    public void deletarDisciplinaPorId(Long codigo) {
        disciplinaRepository.deleteById(codigo);
    }

    public PaginacaoUtil<Disciplina> buscaPorPagina(int paginaAtual) {
        int tamanho = 5;
        Pageable pagina = PageRequest.of(paginaAtual - 1, tamanho);
        List<Disciplina> disciplinas = disciplinaRepositoryPagin.findAll(pagina).toList();
        long totalRegistros = disciplinaRepository.count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
        return new PaginacaoUtil<>(tamanho, paginaAtual, totalDePaginas, disciplinas);
    }

}
