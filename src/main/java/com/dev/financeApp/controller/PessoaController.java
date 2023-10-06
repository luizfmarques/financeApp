package com.dev.financeApp.controller;

import com.dev.financeApp.dto.PessoaDTO;
import com.dev.financeApp.entity.Pessoa;
import com.dev.financeApp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("criar_pessoa")
    public ResponseEntity<PessoaDTO> criarPessoa(@RequestBody PessoaDTO dto) {
        Pessoa pessoa = pessoaService.toEntity(dto);
        pessoa = pessoaService.salvarPessoa(pessoa);
        return ResponseEntity.ok(new PessoaDTO(pessoa));
    }
}
