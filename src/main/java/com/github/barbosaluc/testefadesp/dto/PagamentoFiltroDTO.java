package com.github.barbosaluc.testefadesp.dto;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

public record PagamentoFiltroDTO (
    Long codigoDebito,
    String identificacaoPagador,
    StatusPagamento statusPagamento
) {}
