package com.zupedu.transacao.transacoes;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String transactionId;
    @NotNull @PositiveOrZero
    private BigDecimal valor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;
    private LocalDateTime efetivadaEm;



    public Transacoes() {
    }

    public Transacoes(String transactionId, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.transactionId = transactionId;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public TransacoesDTO toDTO(){
        return new TransacoesDTO(this.id,this.transactionId,this.valor,this.estabelecimento,this.cartao,this.efetivadaEm);
    }
}
