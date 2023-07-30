package com.dev.financeApp.dto;

import com.dev.financeApp.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String login;
    private String senha;
    private String token;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        setLogin(usuario.getLogin());
        setNome(usuario.getNome());
        setSenha(usuario.getSenha());
        setToken(usuario.getToken());
    }

}
