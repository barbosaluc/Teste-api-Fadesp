package com.github.barbosaluc.testefadesp.specification;

import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento

public class PagamentoSpecification {
    
    public static Specification<PagamentoEntity> comIdPagamento(long idPagamento) {
        return (root, query, builder) -> 
            idPagamento == null ? null : builder.equal(root.get("idPagamento"), idPagamento);
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
