package com.bcopstein.ex1biblioeca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSistemaService {

    private final UsuarioSistemaRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioSistemaService(UsuarioSistemaRepository repository,
                                 PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean cadastrar(NovoUsuarioSistemaRequest novo) {
        if (novo == null ||
                novo.username() == null ||
                novo.senha() == null) {
            return false;
        }

        String username = novo.username().trim();
        String senha = novo.senha().trim();

        if (username.isEmpty() ||
                senha.isEmpty() ||
                repository.existsByUsername(username)) {
            return false;
        }

        UsuarioSistema usuario = new UsuarioSistema(
                username,
                passwordEncoder.encode(senha),
                novo.perfilNormalizado()
        );

        repository.save(usuario);
        return true;
    }
}
