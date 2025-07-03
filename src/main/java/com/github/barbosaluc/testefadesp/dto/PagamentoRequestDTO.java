package com.github.barbosaluc.testefadesp.dto;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;

import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PagamentoRequestDTO(

    @NotBlank(message = "A identificação do pagador é obrigatória")    
    String identificacaoPagador,

    @NotNull(message = "O método de pagamento é obrigatório")
    MetodoPagamento metodoPagamento,

    Long numeroCartao,

    @NotNull(message = "O valor do pagamento é obrigatório")
    BigDecimal valorPagamento

) {}