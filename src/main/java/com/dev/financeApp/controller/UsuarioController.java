package com.dev.financeApp.controller;

import com.dev.financeApp.dto.UsuarioDTO;
import com.dev.financeApp.entity.Usuario;
import com.dev.financeApp.service.UsuarioService;
import com.dev.financeApp.util.CriptografiaUtil;
import com.dev.financeApp.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar_usuario")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO dto) {
        UsuarioValidation usuarioValidation = new UsuarioValidation(this.usuarioService);
        usuarioValidation.validarSalvar(dto);
        Usuario usuario = usuarioService.toEntity(dto);
        usuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PostMapping("/logar")
    public ResponseEntity logar(@RequestBody UsuarioDTO dto) {
        UsuarioValidation usuarioValidation = new UsuarioValidation(this.usuarioService);
        usuarioValidation.validarLogar(dto);
        Usuario usuario = usuarioService.buscarUsuarioPorLogin(dto.getLogin());
        String senhaCriptografada = CriptografiaUtil.criptografar(dto.getSenha());
        if (!usuario.getSenha().equals(senhaCriptografada)) {
            throw new IllegalArgumentException("Senha inválida!");
        }
        usuarioService.gerarToken(usuario);
        UsuarioDTO tokenDto = new UsuarioDTO(usuario);
        tokenDto.setToken(usuario.getToken());
        return ResponseEntity.ok(tokenDto);
    }

}
