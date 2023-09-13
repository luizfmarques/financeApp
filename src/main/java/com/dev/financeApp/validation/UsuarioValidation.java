package com.dev.financeApp.validation;

import com.dev.financeApp.dto.UsuarioDTO;
import com.dev.financeApp.service.UsuarioService;

public class UsuarioValidation {

    private UsuarioService usuarioService;

    public UsuarioValidation(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void validarLogar(UsuarioDTO dto) {

        String login = dto.getLogin();
        String senha = dto.getSenha();

        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("O login é obrigatório!");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória!");
        }
        if (!this.usuarioService.loginExistente(login)) {
            throw new IllegalArgumentException("Login não encontrado!");
        }

    }

    public void validarSenha(String senha) {
        if (!senha.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra.");
        }
    }

    public void validarSalvar(UsuarioDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo Nome é obrigatório!");
        }
        if (dto.getLogin() == null || dto.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo Login é obrigatório!");
        }
        if (dto.getSenha() == null || dto.getSenha().trim().isEmpty()) {
            throw new IllegalArgumentException("Campo Senha é obrigatório!");
        } else {
            validarSenha(dto.getSenha());
        }
    }
}
