package com.dev.financeApp.service;

import com.dev.financeApp.dto.MeioPagamentoDTO;
import com.dev.financeApp.entity.MeioPagamento;
import com.dev.financeApp.repository.MeioPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MeioPagamentoService {

    @Autowired
    private MeioPagamentoRepository meioPagamentoRepository;

    public MeioPagamento salvarMeioPagamento(MeioPagamento meioPagamento) {
        meioPagamento.setUltimaAlteracao(LocalDateTime.now());
        return meioPagamentoRepository.save(meioPagamento);
    }

    public boolean nomeExistente(String nome) {
        return meioPagamentoRepository.findByName(nome) != null;
    }

    public MeioPagamento buscarMeioPagamentoPorNome(String nome) {
        return meioPagamentoRepository.findByName(nome);
    }

    public MeioPagamento toEntity(MeioPagamentoDTO dto) {
        MeioPagamento meioPagamento = new MeioPagamento();
        meioPagamento.setNome(dto.getNome());
        meioPagamento.setStatus(dto.isStatus());
        meioPagamento.setUsuario(dto.getUsuario());
        return meioPagamento;
    }


}
