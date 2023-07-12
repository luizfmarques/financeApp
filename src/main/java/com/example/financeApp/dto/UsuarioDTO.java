package com.example.financeApp.dto;

import com.example.financeApp.entity.Usuario;

public class UsuarioDTO {
    private String nome;
    private String login;
    private String senha;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        setLogin(usuario.getLogin());
        setNome(usuario.getNome());
        setSenha(usuario.getSenha());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
