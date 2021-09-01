package com.zupedu.transacao.transacoes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoForm {
    @NotBlank
    private String id;
    @NotBlank @Email
    private String email;

    public CartaoForm(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public CartaoForm() {
    }

    public Cartao toModel() {
        return new Cartao(id,email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
