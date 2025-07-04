import com.github.barbosaluc.testefadesp.domain.enums.StatusPagamento;

public record PagamentoFiltroDTO (
    Long idPagamento,
    String identificacaoPagador,
    StatusPagamento statusPagamento
) {}
