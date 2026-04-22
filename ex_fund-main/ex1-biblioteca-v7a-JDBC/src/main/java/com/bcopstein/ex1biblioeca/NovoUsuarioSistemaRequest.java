package com.bcopstein.ex1biblioeca;

public record NovoUsuarioSistemaRequest(
        String username,
        String senha,
        String perfil) {

    public String perfilNormalizado() {
        if (perfil == null || perfil.isBlank()) {
            return "CONSULTA";
        }

        String p = perfil.trim().toUpperCase();

        if ("ADMIN".equals(p)) {
            return "ADMIN";
        }

        return "CONSULTA";
    }
}
