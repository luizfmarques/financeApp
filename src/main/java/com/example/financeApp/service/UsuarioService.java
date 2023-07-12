package com.example.financeApp.service;

import com.example.financeApp.entity.Usuario;
import com.example.financeApp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setUltimaAlteracao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public boolean loginExistente(String login) {
        return usuarioRepository.findByLogin(login) != null;
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
