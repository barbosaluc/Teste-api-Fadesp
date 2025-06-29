package com.github.barbosaluc.testefadesp.dto;

import jakarta.validation.constraints.NotBlank;

public record PagamentoRequestDTO(

    @NotBlank(message = "A identificação do pagador é obrigatória")    
    String identificacaoPagador,

    @NotBlank(message = "O método de pagamento é obrigatório")
    String metodoPagamento,

    Long numeroCartao,

    @NotBlank(message = "O valor do pagamento é obrigatório")
    Double valorPagamento

) {}