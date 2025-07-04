package com.github.barbosaluc.testefadesp.specification;

import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;
import org.springframework.data.jpa.domain.Specification;

public class PagamentoSpecification {
    
    public static Specification<PagamentoEntity> comCodigoDebito(Long codigoDebito) {
        return (root, query, builder) -> 
            codigoDebito == null ? null : builder.equal(root.get("codigoDebito"), codigoDebito);
    }

    public static Specification<PagamentoEntity> comIdentificacaoPagador(String identificacaoPagador) {
        return (root, query, builder) ->
            identificacaoPagador == null ? null : builder.equal(root.get("identificacaoPagador"), identificacaoPagador);
    }

    public static Specification<PagamentoEntity> comStatusPagamento(StatusPagamento statusPagamento) {
        return (root, query, builder) ->
            statusPagamento == null ? null : builder.equal(root.get("statusPagamento"), statusPagamento);
    }
}
