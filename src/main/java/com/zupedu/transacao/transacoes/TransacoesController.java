package com.zupedu.transacao.transacoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {

    private final TransacoesRepository transacoesRepository;

    public TransacoesController(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    @GetMapping("/{cartao}")
    public ResponseEntity getTransacoes(@PathVariable String cartao){
        try{
            List<Transacoes> transacoes = transacoesRepository.findLast10ByCartao_Cartao(cartao);
            return ResponseEntity.ok(transacoes.stream().map(t->t.toDTO()).collect(Collectors.toList()));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}