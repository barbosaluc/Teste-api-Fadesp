package com.github.barbosaluc.testefadesp.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MetodoPagamento {
    
    BOLETO("Boleto"),
    PIX("Pix"),
    CARTAO_CREDITO("Cartao de Credito"),
    CARTAO_DEBITO("Cartao de Debito");

    private String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }


    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static MetodoPagamento fromJson(String descricao) {
        for (MetodoPagamento metodo : MetodoPagamento.values()) {
            if (metodo.descricao.equalsIgnoreCase(descricao)) {
                return metodo;
            }
        }
    throw new IllegalArgumentException("Método de pagamento inválido: " + descricao);
 }

}



