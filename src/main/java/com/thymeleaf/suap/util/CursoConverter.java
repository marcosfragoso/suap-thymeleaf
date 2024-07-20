package com.thymeleaf.suap.util;

import com.thymeleaf.suap.model.Curso;
import com.thymeleaf.suap.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class CursoConverter implements Converter<String, Curso> {

    @Autowired
    private CursoService cursoService;


    @Override
    public Curso convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long codigo = Long.valueOf(text);
        return cursoService.listarCurso(codigo);
    }
}
