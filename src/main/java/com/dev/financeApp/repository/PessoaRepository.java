package com.dev.financeApp.repository;


import com.dev.financeApp.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByName(String nome);

}
