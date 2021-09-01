package com.zupedu.transacao.transacoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacoesRepository extends JpaRepository<Transacoes,Long> {
    List<Transacoes> findLast10ByCartao_Cartao(String cartaoId);
}
