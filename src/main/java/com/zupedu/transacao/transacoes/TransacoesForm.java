package com.zupedu.transacao.transacoes;

import com.sun.istack.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacoesForm {
    private String id;
    @NotNull @PositiveOrZero
    private BigDecimal valor;
    @ManyToOne
    private EstabelecimentoForm estabelecimento;
    @ManyToOne
    private CartaoForm cartao;
    private LocalDateTime efetivadaEm;



    public TransacoesForm() {
    }

    public TransacoesForm(String id, BigDecimal valor, EstabelecimentoForm estabelecimento, CartaoForm cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacoes toModel(){
        return new Transacoes(this.id,this.valor,this.estabelecimento.toModel(),this.cartao.toModel(),this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "TransacoesForm{" +
                "cartaoId='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento.toString() +
                ", cartao=" + cartao.toString() +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getCartaoId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoForm getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(EstabelecimentoForm estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(CartaoForm cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
