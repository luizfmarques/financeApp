package com.dev.financeApp.repository;

import com.dev.financeApp.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Despesa findByName(String nome);
}
