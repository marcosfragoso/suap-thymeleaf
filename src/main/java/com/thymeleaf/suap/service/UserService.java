package com.thymeleaf.suap.service;

import com.thymeleaf.suap.model.Perfil;
import com.thymeleaf.suap.model.Usuario;
import com.thymeleaf.suap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {

        Usuario usuario = buscaPorUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente!"));

        User userSpring = new User(
                usuario.getUsername(),
                usuario.getSenha(),
                AuthorityUtils.createAuthorityList(getAuthorities(usuario.getPerfis()))
        );
        return userSpring;

    }

    private String[] getAuthorities(List<Perfil> perfis) {
        String[] authorities = new String[perfis.size()];
        for (int i = 0; i < perfis.size(); i++) {
            authorities[i] = perfis.get(i).getNome();
        }
        return authorities;
    }

    @Transactional(readOnly = true)
    private Optional<Usuario> buscaPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Transactional(readOnly = false)
    public void salvarUsuario(Usuario usuario) {
        String crypt = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(crypt);
        usuarioRepository.save(usuario);
    }


}
