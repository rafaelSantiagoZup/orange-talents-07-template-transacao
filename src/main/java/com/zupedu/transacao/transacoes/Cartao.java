package com.zupedu.transacao.transacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cartao;
    @NotBlank @Email
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String cartao, String email) {
        this.cartao = cartao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}