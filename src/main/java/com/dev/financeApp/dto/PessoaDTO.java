package com.dev.financeApp.dto;

import com.dev.financeApp.entity.Pessoa;
import com.dev.financeApp.entity.Usuario;
import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private boolean status;
    private Usuario usuario;

    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa pessoa) {
        setNome(pessoa.getNome());
        setStatus(pessoa.isStatus());
        setUsuario(pessoa.getUsuario());
    }
}
