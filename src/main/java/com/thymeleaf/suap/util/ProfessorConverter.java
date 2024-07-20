package com.thymeleaf.suap.util;

import com.thymeleaf.suap.model.Professor;
import com.thymeleaf.suap.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class ProfessorConverter implements Converter<String, Professor> {
    @Autowired
    private ProfessorService professorService;


    @Override
    public Professor convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long matricula = Long.valueOf(text);
        return professorService.listarProfessor(matricula);
    }
}
