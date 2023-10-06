package com.dev.financeApp.repository;

import com.dev.financeApp.entity.MeioPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeioPagamentoRepository extends JpaRepository<MeioPagamento, Long> {

    MeioPagamento findByName(String nome);
}
