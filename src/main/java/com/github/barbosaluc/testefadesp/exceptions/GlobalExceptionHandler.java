package com.github.barbosaluc.testefadesp.exceptions;

import com.github.barbosaluc.testefadesp.exceptions.pagamentos.PagamentoNaoEncontradoException;
import com.github.barbosaluc.testefadesp.exceptions.pagamentos.StatusInvalidoException;
import com.github.barbosaluc.testefadesp.exceptions.pagamentos.StatusPagamentoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagamentoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handlePagamentoNaoEncontrado(PagamentoNaoEncontradoException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StatusPagamentoInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleStatusPagamentoInvalido(StatusPagamentoInvalidoException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StatusInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleStatusInvalido(StatusInvalidoException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

}