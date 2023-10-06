package com.dev.financeApp.controller;

import com.dev.financeApp.dto.MeioPagamentoDTO;
import com.dev.financeApp.entity.MeioPagamento;
import com.dev.financeApp.service.MeioPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meio_pagamento")
public class MeioPagamentoController {

    @Autowired
    private MeioPagamentoService meioPagamentoService;

    @PostMapping("criar_meio_pagamento")
    public ResponseEntity<MeioPagamentoDTO> criarMeioPagamento(@RequestBody MeioPagamentoDTO dto) {
        MeioPagamento meioPagamento = meioPagamentoService.toEntity(dto);
        meioPagamento = meioPagamentoService.salvarMeioPagamento(meioPagamento);
        return ResponseEntity.ok(new MeioPagamentoDTO(meioPagamento));
    }
}
