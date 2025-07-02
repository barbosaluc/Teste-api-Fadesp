package com.github.barbosaluc.testefadesp.dto;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

public record PagamentoResponseDTO (
    Long idPagamento,
    String identificacaoPagador,
    MetodoPagamento metodoPagamento,
    Long numeroCartao,
    Double valorPagamento,
    StatusPagamento statusPagamento
) {}
