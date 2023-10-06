package com.dev.financeApp.service;

import com.dev.financeApp.dto.PessoaDTO;
import com.dev.financeApp.entity.Pessoa;
import com.dev.financeApp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa) {
        pessoa.setUltimaAlteracao(LocalDateTime.now());
        return pessoaRepository.save(pessoa);
    }

    public boolean nomeExistente(String nome) {
        return pessoaRepository.findByName(nome) != null;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        return pessoaRepository.findByName(nome);
    }

    public Pessoa toEntity(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setStatus(dto.isStatus());
        pessoa.setUsuario(dto.getUsuario());
        return pessoa;
    }
}
