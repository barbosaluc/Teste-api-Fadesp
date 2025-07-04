package com.github.barbosaluc.testefadesp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;
import com.github.barbosaluc.testefadesp.domain.enums.Status;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;
import com.github.barbosaluc.testefadesp.dto.PagamentoRequestDTO;
import com.github.barbosaluc.testefadesp.dto.PagamentoResponseDTO;
import com.github.barbosaluc.testefadesp.dto.PagamentoFiltroDTO;
import com.github.barbosaluc.testefadesp.persistence.repositories.IPagamentoRepository;
import com.github.barbosaluc.testefadesp.specification.PagamentoSpecification;
import com.github.barbosaluc.testefadesp.util.PagamentoMapper;
import static com.github.barbosaluc.testefadesp.util.PagamentoMapper.toEntityFromRequest;
import static com.github.barbosaluc.testefadesp.util.PagamentoMapper.toResponseFromEntity;

import jakarta.transaction.Transactional;

@Service
public class PagamentoService {
    
    private final IPagamentoRepository iPagamentoRepository;
    private final Logger logger = LoggerFactory.getLogger(PagamentoService.class);

    public PagamentoService(IPagamentoRepository iPagamentoRepository) {
        this.iPagamentoRepository = iPagamentoRepository;
    }

    public PagamentoResponseDTO criarPagamento(PagamentoRequestDTO pagamentoRequestDTO) {
        logger.info("PagamentoService.criarPagamento - Iniciando o processamento do pagamento");
        try {
            PagamentoEntity pagamentoEntity = toEntityFromRequest(pagamentoRequestDTO);
            PagamentoResponseDTO pagamentoResponseDTO = toResponseFromEntity(iPagamentoRepository.save(pagamentoEntity));
            logger.info("PagamentoService.criarPagamento - Pagamento criado com sucesso com ID: {}", pagamentoEntity.getIdPagamento());
            return pagamentoResponseDTO;
        } catch (Exception e) {
            logger.error("PagamentoService.criarPagamento - Erro ao criar pagamento com ID: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao criar pagamento", e);
        } 
    } 
    

    public PagamentoResponseDTO buscarPagamentoPorId(Long idPagamento) {
        logger.info("PagamentoService.bucarPagamentoPorId - Buscando pagamento com ID: {}", idPagamento);
        try {
            Optional<PagamentoEntity> pagamentoEntityOptional = iPagamentoRepository.findById(idPagamento);
            if(pagamentoEntityOptional.isPresent()) {
                logger.info("PagamentoService.buscarPagamentoPorId - Pagamento encontrado com ID; {}", idPagamento);
                return toResponseFromEntity(pagamentoEntityOptional.get());
            } else {
                logger.warn("PagamentoSerivce.buscarPagamentoPorId - Pagamento não encontrado com ID: {}", idPagamento);
                return null;
            }
        } catch ( Exception e) {
            logger.error("PagamentoService.buscarPagamentoPorId - Erro ao buscar pagamento com ID: {}", idPagamento, e.getMessage(), e);
            throw new RuntimeException("Erro ao buscar pagamento", e);
        }
    }

    public List<PagamentoResponseDTO> listarPagamentos() {
        logger.info("PagamentoService.listarPagamentos - Listando todos os pagamentos");
        try {
            List<PagamentoEntity> pagamentos = iPagamentoRepository.findAll();
            return pagamentos.stream()
                    .map(PagamentoMapper::toResponseFromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("PagamentoService.listarPagamentos - Erro ao listar pagamentos {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao listar pagamentos", e);
        }
    }

    public List<PagamentoResponseDTO> buscarPagamentosPorFiltro(PagamentoFiltroDTO pagamentoFiltroDTO) {
        logger.info("PagamentoService.buscarPagamentosPorFiltro - Buscando pagamentos com filtros: {}", pagamentoFiltroDTO);

        Specification<PagamentoEntity> spec = PagamentoSpecification.comCodigoDebito(pagamentoFiltroDTO.codigoDebito())
            .and(PagamentoSpecification.comIdentificacaoPagador(pagamentoFiltroDTO.identificacaoPagador()))
            .and(PagamentoSpecification.comStatusPagamento(pagamentoFiltroDTO.statusPagamento()));

        List<PagamentoEntity> pagamentos = iPagamentoRepository.findAll(spec);
        logger.info("PagamentoService.buscarPagamentosPorFiltro - Encontrados {} pagamentos com os filtros fornecidos", pagamentos.size());
        return pagamentos.stream()
            .map(PagamentoMapper::toResponseFromEntity)
            .toList();
    }

    @Transactional
    public PagamentoResponseDTO atualizarPagamento(long idPagamento, PagamentoRequestDTO pagamentoRequestDTO, StatusPagamento novoStatus) {
        logger.info("PagamentoService.atualizarPagamento - Atualizando pagamento com ID: {}", idPagamento);
        try {
            PagamentoEntity pagamentoEntity = iPagamentoRepository.findById(idPagamento)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com ID: " + idPagamento));
/*
            pagamentoEntity.setIdentificacaoPagador(pagamentoRequestDTO.identificacaoPagador());
            pagamentoEntity.setMetodoPagamento(pagamentoRequestDTO.metodoPagamento());
            pagamentoEntity.setNumeroCartao(pagamentoRequestDTO.numeroCartao());
            pagamentoEntity.setValorPagamento(pagamentoRequestDTO.valorPagamento());
*/
            if (pagamentoEntity.getStatusPagamento() == StatusPagamento.PENDENTE_PROCESSAMENTO && novoStatus == StatusPagamento.PROCESSADO_SUCESSO) {
                pagamentoEntity.setDataPagamento(LocalDateTime.now());
            }

            if (pagamentoEntity.getStatusPagamento() == StatusPagamento.PROCESSADO_SUCESSO) {
                throw new IllegalStateException("Não é permitido alterar o status de um pagamento processado com sucesso");
            }

            if (pagamentoEntity.getStatusPagamento() == StatusPagamento.PROCESSADO_FALHA && novoStatus != StatusPagamento.PENDENTE_PROCESSAMENTO ) {
                throw new IllegalStateException("Só é permitido alterar o pagamento processado com falha para processamento pendente");
            }

            pagamentoEntity.setStatusPagamento(novoStatus);
            iPagamentoRepository.save(pagamentoEntity);
            logger.info("PagamentoService.atualizarPagamento - Pagamento atualizado com sucesso com ID: {}", idPagamento);
            return toResponseFromEntity(pagamentoEntity);
        } catch (Exception e) {
            logger.error("PagamentoService.atualizarPagamento - Erro ao atualizar pagamento: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao atualizar pagamento", e);
        }
    }

    public void excluirPagamentoLogicamente(Long idPagamento) {
        logger.info("PagamentoService.excluirPagamentoLogicamente - Tentando inativar pagamento com ID: {}", idPagamento);
        try {
            PagamentoEntity pagamentoEntity = iPagamentoRepository.findById(idPagamento)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com ID: " + idPagamento));

                if(pagamentoEntity.getStatusPagamento() != StatusPagamento.PENDENTE_PROCESSAMENTO) {
                    throw new IllegalStateException("Pagamento só pode ser inativado se estiver com o processamento pendente");
                }
            
            pagamentoEntity.setStatus(Status.INATIVO);
            iPagamentoRepository.save(pagamentoEntity);
            logger.info("PagamentoService.excluirPagamentoLogicamente - Pagamento inativado com sucesso. ID: {}", idPagamento);
        } catch (Exception e) {
            logger.error("PagamentoService.excluirPagamentoLogicamente - Erro ao inativar pagamento com ID: {}", idPagamento, e.getMessage(), e);
            throw new RuntimeException("Erro ao inativar pagamento", e);
        }
    }

}
