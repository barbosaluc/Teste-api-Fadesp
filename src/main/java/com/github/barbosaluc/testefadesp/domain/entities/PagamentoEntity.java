package com.github.barbosaluc.testefadesp.domain.entities;

import com.github.barbosaluc.testefadesp.domain.enums.MetodoPagamento;
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

    @NotBlank(message = "A identificação do pagador é obrigatória" )
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
    private Double valorPagamento;

    @NotNull(message = "O status do pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_PAGAMENTO", nullable = false)
    private StatusPagamento statusPagamento;
    
}
