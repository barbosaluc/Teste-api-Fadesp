package com.github.barbosaluc.testefadesp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;
import com.github.barbosaluc.testefadesp.domain.enums.Status;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

public record PagamentoResponseDTO (
        Long idPagamento,
        Long codigoDebito,
        String identificacaoPagador,
        MetodoPagamento metodoPagamento,
        String numeroCartao,
        BigDecimal valorPagamento,
        StatusPagamento statusPagamento,
        LocalDateTime dataPagamento,
        Status status
) {}
