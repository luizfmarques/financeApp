package com.dev.financeApp.service;

import com.dev.financeApp.dto.DespesaDTO;
import com.dev.financeApp.entity.Despesa;
import com.dev.financeApp.entity.Pessoa;
import com.dev.financeApp.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvarDespesa(Despesa despesa){
        despesa.setUltimaAlteracao(LocalDateTime.now());
        return despesaRepository.save(despesa);
    }

    public boolean nomeExistente(String nome) {
        return despesaRepository.findByName(nome) != null;
    }

    public Despesa buscarDespesaPorNome(String nome){
        return despesaRepository.findByName(nome);
    }

    public Despesa toEntity(DespesaDTO dto){
        Despesa despesa = new Despesa();
        despesa.setNome(dto.getNome());
        despesa.setStatus(dto.isStatus());
        despesa.setUsuario(dto.getUsuario());
        return despesa;
    }
}
