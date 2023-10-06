package com.dev.financeApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEIO_PAGAMENTO")
@Data
public class MeioPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private LocalDateTime ultimaAlteracao;

    private Usuario usuario;

    public MeioPagamento() {

    }

}
