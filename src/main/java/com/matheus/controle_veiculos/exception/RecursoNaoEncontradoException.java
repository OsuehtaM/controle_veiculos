package com.matheus.controle_veiculos.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(String recurso, Long id) {
        super( recurso + " não encontrado com o ID " + id);
    }
}
