package com.thymeleaf.suap.security;

import com.thymeleaf.suap.util.PerfilTipo;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String COORDENADOR = PerfilTipo.COORDENADOR.getDesc();
    private static final String PROFESSOR = PerfilTipo.PROFESSOR.getDesc();
    private static final String ESTUDANTE = PerfilTipo.ESTUDANTE.getDesc();

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(
                        antMatcher("/webjars/**"),
                        antMatcher("/css/**"),
                        antMatcher("/images/**"),
                        antMatcher("/js/**")
                        ).permitAll()
                .requestMatchers(
                        antMatcher("/alunos/**")
                ).hasAnyAuthority(ADMIN, ESTUDANTE)
                .requestMatchers(
                        antMatcher("/cursos/**")
                ).hasAnyAuthority(ADMIN, COORDENADOR)
                .requestMatchers(
                        antMatcher("/disciplinas/**")
                ).hasAnyAuthority(ADMIN, COORDENADOR)
                .requestMatchers(
                        antMatcher("/matriculas/**")
                ).hasAnyAuthority(ADMIN, ESTUDANTE)
                .requestMatchers(
                        antMatcher("/professores/**")
                ).hasAnyAuthority(ADMIN, PROFESSOR)
                .requestMatchers(
                        antMatcher("/professores/**")
                ).hasAnyAuthority(ADMIN, PROFESSOR)
                .requestMatchers(
                        antMatcher("/home")
                ).hasAnyAuthority(ADMIN, COORDENADOR, PROFESSOR, ESTUDANTE)
                .requestMatchers(
                        antMatcher("/")
                ).hasAnyAuthority(ADMIN, COORDENADOR, PROFESSOR, ESTUDANTE)
                .anyRequest().authenticated()
                ).formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login-error")
                        .permitAll()
                ).logout((logout) -> logout
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID")
                ).exceptionHandling((ex) -> ex
                .accessDeniedPage("acesso-negado")
                ).rememberMe(
                     Customizer.withDefaults()
                ).sessionManagement((session) -> session
                        .maximumSessions(1)
                        .expiredUrl("/expired")
                        .sessionRegistry(sessionRegistry())
                ).sessionManagement(session -> session
                        .invalidSessionUrl("expired")
                ).sessionManagement((session) -> session
                        .sessionFixation()
                        .newSession()
                        .sessionAuthenticationStrategy(sessionAuthStrategy())
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SessionAuthenticationStrategy sessionAuthStrategy() {
        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public ServletListenerRegistrationBean<?> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }
}
