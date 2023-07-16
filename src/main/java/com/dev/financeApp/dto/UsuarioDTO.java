package com.dev.financeApp.dto;

import com.dev.financeApp.entity.Usuario;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
