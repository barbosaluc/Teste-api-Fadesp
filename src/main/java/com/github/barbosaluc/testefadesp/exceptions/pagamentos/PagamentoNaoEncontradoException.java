package com.github.barbosaluc.testefadesp.exceptions.pagamentos;

public class PagamentoNaoEncontradoException extends RuntimeException {
    public PagamentoNaoEncontradoException(String message) {
        super(message);
    }
}