package com.github.barbosaluc.testefadesp.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;
import com.github.barbosaluc.testefadesp.domain.enums.Status;
import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TAB_PAGAMENTOS")
public class PagamentoEntity {
    
    @Id
    @Column(name = "ID_PAGAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @NotNull(message = "O código do débito é obrigatório")
    @Column(name = "CODIGO_DEBITO", nullable = false)
    private Long codigoDebito;

    @NotBlank(message = "A identificação do pagador é obrigatória" )
    @Pattern(
            regexp = "^\\d{11}|\\d{14}$",
            message = "A identificação do pagador deve conter 11 (CPF) ou 14 (CNPJ) dígitos numéricos"
    )
    @Column(name = "IDENTIFICACAO_PAGADOR", nullable = false)
    private String identificacaoPagador;

    @NotNull(message = "O método de pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "METODO_PAGAMENTO", nullable = false)
    private MetodoPagamento metodoPagamento;

    @Column(name = "NUMERO_CARTAO")
    private Long numeroCartao;

    @NotNull(message = "O valor do pagamento é obrigatório")
    @Column(name = "VALOR_PAGAMENTO", nullable = false)
    private BigDecimal valorPagamento;

    @NotNull(message = "O status do pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_PAGAMENTO", nullable = false)
    private StatusPagamento statusPagamento;

    @NotNull(message = "A data do pagamento não pode ser nula")
    @Column(name = "DATA_PAGAMENTO")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dataPagamento;

    @NotBlank(message = "O status do pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status = Status.ATIVO;
    
}
