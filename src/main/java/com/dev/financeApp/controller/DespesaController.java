package com.dev.financeApp.controller;

import com.dev.financeApp.dto.DespesaDTO;
import com.dev.financeApp.entity.Despesa;
import com.dev.financeApp.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping("criar_despesa")
    public ResponseEntity<DespesaDTO> criarDespesa(@RequestBody DespesaDTO dto){
        Despesa despesa = despesaService.toEntity(dto);
        despesa = despesaService.salvarDespesa(despesa);
        return ResponseEntity.ok(new DespesaDTO(despesa));
    }

}
