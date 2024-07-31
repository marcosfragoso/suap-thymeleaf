package com.thymeleaf.suap.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/home"})
    public String home(ExpiresFilter.XHttpServletResponse) {
        return "/home";
    }

    @GetMapping({"/login", "/"})
    public String login(){
        return "login";
    }

    @GetMapping({"/login-error"})
    public String loginError(ModelMap model, HttpServletRequest resp) {
        HttpSession session = resp.getSession();
        String lastException = String.valueOf(session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION"));
        if (lastException.contains(SessionAuthenticationException.class.getName())) {
            model.addAttribute("alerta", "erro");
            model.addAttribute("titulo", "Acesso recusado!");
            model.addAttribute("texto", "Você já está logado em outro dispositivo.");
            model.addAttribute("subtexto", "Faça o logout ou espere sua sessão expirar.");
            return "login";
        }
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Credenciais inválidas!");
        model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
        model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativados.");
        return "login";
    }

    public String sessaoExpirada(ModelMap model) {
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Acesso recusado!");
        model.addAttribute("texto", "Sua sessão expirou.");
        model.addAttribute("subtexto", "Você logou em outro dispositivo.");
        return "login";
    }
}
