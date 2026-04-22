package com.bcopstein.ex1biblioeca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsConfig {
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService(
            UsuarioSistemaRepository repository) {

        return username -> {
            UsuarioSistema user = repository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            return User.builder()
                    .username(user.getUsername())
                    .password(user.getSenha())
                    .authorities("ROLE_" + user.getPerfil())
                    .build();
        };
    }
}