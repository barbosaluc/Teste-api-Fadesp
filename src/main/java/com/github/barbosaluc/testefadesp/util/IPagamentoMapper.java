package com.github.barbosaluc.testefadesp.util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;
import com.github.barbosaluc.testefadesp.dto.PagamentoRequestDTO;
import com.github.barbosaluc.testefadesp.dto.PagamentoResponseDTO;

@Mapper(componentModel = "spring")
public interface IPagamentoMapper {
 
    IPagamentoMapper INSTANCE = Mappers.getMapper(IPagamentoMapper.class);

    @Mapping(target = "idPagamento", ignore = true)
    @Mapping(target = "statusPagamento", expression = "java(StatusPagamento.PENDENTE_PROCESSAMENTO)")
    PagamentoEntity toEntity(PagamentoRequestDTO dto); 

    @Mapping(source  = "metodoPagamento.descricao", target = "metodoPagamento")
    @Mapping(source = "statusPagamento.descricao", target = "statusPagamento")
    PagamentoResponseDTO toResponseDTO(PagamentoEntity entity);
}

