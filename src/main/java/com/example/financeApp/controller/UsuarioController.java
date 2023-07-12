package com.example.financeApp.controller;

import com.example.financeApp.dto.UsuarioDTO;
import com.example.financeApp.entity.Usuario;
import com.example.financeApp.service.UsuarioService;
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
        Usuario usuario = toEntity(dto);
        usuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PostMapping("/logar")
    public ResponseEntity logar(@RequestBody UsuarioDTO dto) {
        String login = dto.getLogin();
        String senha = dto.getSenha();

        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("O login é obrigatório!");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória!");
        }
        if (!usuarioService.loginExistente(login)) {
            throw new IllegalArgumentException("Login não encontrado!");
        }

        Usuario usuario = usuarioService.buscarUsuarioPorLogin(login);
        String senhaCriptografada = criptografarSenha(senha);
        if (!usuario.getSenha().equals(senhaCriptografada)) {
            throw new IllegalArgumentException("Senha inválida!");
        }

        return ResponseEntity.ok("Login ok");

       // String token = criarTokenAleatorio();

    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setNome(dto.getNome());
        String senha = dto.getSenha();
        if (!senha.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra.");
        }
        String senhaCriptografada = criptografarSenha(senha);
        usuario.setSenha(senhaCriptografada);
        return usuario;
    }


    private String criptografarSenha(String senha) {
        int deslocamento = 3;
        StringBuilder senhaCriptografada = new StringBuilder();
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);
            if (Character.isLetter(caractere)) {
                char novoCaractere = (char) (((caractere - 'a' + deslocamento) % 26) + 'a');
                senhaCriptografada.append(novoCaractere);
            } else {
                senhaCriptografada.append(caractere);
            }
        }
        return senhaCriptografada.toString();
    }

    private String descriptografarSenha(String senhaCriptografada) {
        int deslocamento = 3;
        StringBuilder senhaDescriptografada = new StringBuilder();
        for (int i = 0; i < senhaCriptografada.length(); i++) {
            char caractere = senhaCriptografada.charAt(i);
            if (Character.isLetter(caractere)) {
                char novoCaractere = (char) (((caractere - 'a' - deslocamento + 26) % 26) + 'a');
                senhaDescriptografada.append(novoCaractere);
            } else {
                senhaDescriptografada.append(caractere);
            }
        }
        return senhaDescriptografada.toString();
    }
}
