package com.github.barbosaluc.testefadesp.util;


import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;
import com.github.barbosaluc.testefadesp.domain.enums.Status;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;
import com.github.barbosaluc.testefadesp.dto.PagamentoRequestDTO;
import com.github.barbosaluc.testefadesp.dto.PagamentoResponseDTO;

public class PagamentoMapper {
    public static PagamentoResponseDTO toResponseFromEntity(PagamentoEntity pagamentoEntity) {
        return new PagamentoResponseDTO (
            pagamentoEntity.getCodigoDebito(),
            pagamentoEntity.getIdPagamento(),
            pagamentoEntity.getIdentificacaoPagador(),
            pagamentoEntity.getMetodoPagamento(),
            pagamentoEntity.getNumeroCartao(),
            pagamentoEntity.getValorPagamento(),
            pagamentoEntity.getStatusPagamento(),
            pagamentoEntity.getDataPagamento(),
            pagamentoEntity.getStatus()

        );
    }
  
    public static PagamentoEntity toEntityFromRequest(PagamentoRequestDTO pagamentoRequestDTO) {
        return new PagamentoEntity(
            null,
            pagamentoRequestDTO.codigoDebito(),
            pagamentoRequestDTO.identificacaoPagador(),
            pagamentoRequestDTO.metodoPagamento(),
            pagamentoRequestDTO.numeroCartao(),
            pagamentoRequestDTO.valorPagamento(),
            StatusPagamento.PENDENTE_PROCESSAMENTO,
            null,
            Status.ATIVO
        );
    }
}

