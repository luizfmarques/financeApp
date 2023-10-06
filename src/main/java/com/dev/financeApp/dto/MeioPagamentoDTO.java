package com.dev.financeApp.dto;

import com.dev.financeApp.entity.MeioPagamento;
import com.dev.financeApp.entity.Usuario;
import lombok.Data;

@Data
public class MeioPagamentoDTO {
    private String nome;
    private boolean status;
    private Usuario usuario;

    public MeioPagamentoDTO() {

    }

    public MeioPagamentoDTO(MeioPagamento meioPagamento) {
        setNome(meioPagamento.getNome());
        setStatus(meioPagamento.isStatus());
        setUsuario(meioPagamento.getUsuario());
    }

}
