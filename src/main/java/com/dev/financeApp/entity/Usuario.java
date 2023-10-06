package com.dev.financeApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "TB_USERS")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 255)
    private String login;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(unique = true, length = 10)
    private String token;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Column(nullable = false)
    private LocalDateTime ultimaAlteracao;



    public Usuario() {
    }
}
