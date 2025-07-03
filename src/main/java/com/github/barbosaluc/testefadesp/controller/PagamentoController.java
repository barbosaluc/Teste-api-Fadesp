package com.github.barbosaluc.testefadesp.controller;

import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.barbosaluc.testefadesp.dto.PagamentoRequestDTO;
import com.github.barbosaluc.testefadesp.dto.PagamentoResponseDTO;
import com.github.barbosaluc.testefadesp.services.PagamentoService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    @Operation(summary = "Criar pagamento", description = "Este endpoint cria um novo pagamento no sistema com base nos dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pagamento criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro de validação ao criar pagamento.")
    })
    public ResponseEntity<PagamentoResponseDTO> criarPagamento(@Valid @RequestBody PagamentoRequestDTO pagamentoRequestDTO) {
        PagamentoResponseDTO pagamentoResponseDto = pagamentoService.criarPagamento(pagamentoRequestDTO);
        if (pagamentoResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{idPagamento}")
    @Operation(summary = "Buscar pagamento por ID", description = "Este endpoint busca um pagamento pelo seu ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    public ResponseEntity<PagamentoResponseDTO> buscarPagamentoPorId(@PathVariable Long idPagamento) {
        PagamentoResponseDTO pagamentoResponseDto = pagamentoService.buscarPagamentoPorId(idPagamento);
        return ResponseEntity.ok(pagamentoResponseDto);
    }

    @PutMapping("/{idPagamento}")
    @Operation(summary = "Atualizar pagamento", description = "Este endpoint atualiza um pagamento existente no sistema com base no ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pagamento atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Pagamento não encontrado.")
    })
    public ResponseEntity<PagamentoResponseDTO> atualizarPagamento(@PathVariable Long idPagamento, @Valid @RequestBody PagamentoRequestDTO pagamentoRequestDTO,  StatusPagamento statusPagamento) {
        PagamentoResponseDTO pagamentoResponseDto = pagamentoService.atualizarPagamento(idPagamento, pagamentoRequestDTO, statusPagamento);
        if (pagamentoResponseDto != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pagamentoResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{idPagamento}")
    @Operation(summary = "Excluir pagamento logicamente", description = "Este endpoint exclui um pagamento logicamente do sistema com base no ID fornecido.")
    public ResponseEntity<Void> excluirPagamentoLogicamente (@PathVariable Long idPagamento) {
        pagamentoService.excluirPagamentoLogicamente(idPagamento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
 
}
