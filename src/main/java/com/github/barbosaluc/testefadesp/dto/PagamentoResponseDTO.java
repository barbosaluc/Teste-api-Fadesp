package com.github.barbosaluc.testefadesp.dto;

public record PagamentoResponseDTO (
    Long idPagamento,
    String identificacaoPagador,
    String metodoPagamento,
    Long numeroCartao,
    Double valorPagamento,
    String statusPagamento
) {}
