package com.github.barbosaluc.testefadesp.domain.enums;


public enum StatusPagamento {

    PENDENTE_PROCESSAMENTO("Pendente de Processamento"),
    PROCESSADO_SUCESSO("Processado com Sucesso"),
    PROCESSADO_FALHA("Processado com Falha");

    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

}
