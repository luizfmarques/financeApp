package com.dev.financeApp.dto;

import com.dev.financeApp.entity.Despesa;
import com.dev.financeApp.entity.Usuario;
import lombok.Data;

@Data
public class DespesaDTO {
    private String nome;
    private boolean status;
    private Usuario usuario;

    public  DespesaDTO(){

    }

    public DespesaDTO(Despesa despesa){
        setNome(despesa.getNome());
        setStatus(despesa.isStatus());
        setUsuario(despesa.getUsuario());
    }

}
