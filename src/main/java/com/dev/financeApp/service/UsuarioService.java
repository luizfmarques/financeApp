package com.dev.financeApp.service;

import com.dev.financeApp.dto.UsuarioDTO;
import com.dev.financeApp.entity.Usuario;
import com.dev.financeApp.repository.UsuarioRepository;
import com.dev.financeApp.util.CriptografiaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public void gerarToken(Usuario usuario) {
        boolean naoTemToken = true;
        while (naoTemToken) {
            String token = gerarTokenAleatorio();
            if (!usuarioRepository.existsByToken(token)) {
                usuario.setToken(token);
                naoTemToken = false;
            }
        }
        salvarUsuario(usuario);
    }

    private String gerarTokenAleatorio() {
        String token = UUID.randomUUID().toString();
        return token.substring(0, 10);
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setNome(dto.getNome());
        String senhaCriptografada = CriptografiaUtil.criptografarSenha(dto.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuario;
    }
}
