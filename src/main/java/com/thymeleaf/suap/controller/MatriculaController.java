package com.thymeleaf.suap.controller;

import com.thymeleaf.suap.model.*;
import com.thymeleaf.suap.service.AlunoService;
import com.thymeleaf.suap.service.DisciplinaService;
import com.thymeleaf.suap.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MatriculaService matriculaService;

    @ModelAttribute("listaDisciplinas")
    public List<Disciplina> getDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        Map<String, List<Disciplina>> disciplinaPorPeriodo = matriculaService.buscarDisciplinasporPeriodo(alunoService.listarAluno(Long.valueOf(4)));
        model.addAttribute("disciplinasPorPeriodo", disciplinaPorPeriodo);
        return "matriculas/lista";
    }

    @PostMapping("/salvar")
    public String salvar(AlunoMatriculaDTO alunoMatricula, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "matriculas/cadastro";
        }
        List<Matricula> matriculas = new ArrayList<>();
        for (Disciplina disciplina : alunoMatricula.getDisciplinas()) {
            MatriculaID matriculaID = new MatriculaID(alunoMatricula.getMatricula(), disciplina.getCodigo(), alunoMatricula.getPeriodo());
            Aluno aluno = alunoService.listarAluno(alunoMatricula.getMatricula());
            Matricula matricula = new Matricula(matriculaID, aluno, disciplina, alunoMatricula.getPeriodo());
            matriculas.add(matricula);
        }
        matriculaService.cadastrarMatricula(matriculas);
        attr.addFlashAttribute("sucesso", "Matrícula salva com sucesso!");
        return "redirect:/matriculas/cadastrar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model) {
        model.addAttribute("alunoMatricula", new AlunoMatriculaDTO());
        return "/matriculas/cadastro";
    }


}
