package com.thymeleaf.suap.controller;

import com.thymeleaf.suap.model.Disciplina;
import com.thymeleaf.suap.model.Professor;
import com.thymeleaf.suap.model.Curso;
import com.thymeleaf.suap.service.CursoService;
import com.thymeleaf.suap.service.DisciplinaService;
import com.thymeleaf.suap.service.ProfessorService;
import com.thymeleaf.suap.util.PaginacaoUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Disciplina disciplina) {
        return "/disciplinas/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "disciplinas/cadastro";
        }
        disciplinaService.cadastrarDisciplina(disciplina);
        attr.addFlashAttribute("sucesso", "Disciplina salvo com sucesso!");
        return "redirect:/disciplinas/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model, @RequestParam("page")Optional<Integer> page) {
        int paginaAtual = page.orElse(1);
        PaginacaoUtil<Disciplina> pageDisciplina = disciplinaService.buscaPorPagina(paginaAtual);
        model.addAttribute("pageDisciplina", pageDisciplina);
        return "/disciplinas/lista";
    }

    @GetMapping("/editar/{codigo}")
    public String preEditar(@PathVariable("codigo") Long codigo, ModelMap model) {
        Disciplina disciplina = disciplinaService.listarDisciplina(codigo);
        model.addAttribute("disciplina", disciplina);
        return "/disciplinas/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Disciplina disciplina, RedirectAttributes attr) {
        disciplinaService.atualizarDisciplina(disciplina);
        attr.addFlashAttribute("sucesso", "Disciplina editado com sucesso!");
        return "redirect:/disciplinas/cadastrar";
    }

    @GetMapping("excluir/{codigo}")
    public void excluir(@PathVariable("codigo") Long codigo, ModelMap model){
        disciplinaService.deletarDisciplinaPorId(codigo);
        model.addAttribute("sucesso", "Disciplina excluído com sucesso!");
    }

    @ModelAttribute("cursos")
    public List<Curso> getCursos() {
        return cursoService.listarCursos();
    }

    @ModelAttribute("professores")
    public List<Professor> getProfessores() {
        return professorService.listarProfessores();
    }

}
