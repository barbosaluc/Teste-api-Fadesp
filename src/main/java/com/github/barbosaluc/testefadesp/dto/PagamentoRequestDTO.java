package com.github.barbosaluc.testefadesp.dto;

import java.math.BigDecimal;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PagamentoRequestDTO(

    @NotNull(message = "O código do débito é obrigatório")
    Long codigoDebito,

    @NotBlank(message = "A identificação do pagador é obrigatória")    
    String identificacaoPagador,

    @NotNull(message = "O método de pagamento é obrigatório")
    MetodoPagamento metodoPagamento,

    Long numeroCartao,

    @NotNull(message = "O valor do pagamento é obrigatório")
    BigDecimal valorPagamento

) {}