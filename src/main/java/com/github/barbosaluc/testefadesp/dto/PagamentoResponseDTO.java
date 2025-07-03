package com.github.barbosaluc.testefadesp.dto;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;
import com.github.barbosaluc.testefadesp.domain.enums.Status;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponseDTO (
        Long idPagamento,
        String identificacaoPagador,
        MetodoPagamento metodoPagamento,
        Long numeroCartao,
        BigDecimal valorPagamento,
        StatusPagamento statusPagamento,
        LocalDateTime dataPagamento,
        Status status
) {}
