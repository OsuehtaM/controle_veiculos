package com.matheus.controle_veiculos.exception;

import com.matheus.controle_veiculos.veiculo.exception.PlacaIndisponivel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleRecursoNaoEncontrado(RecursoNaoEncontradoException recursoNaoEncontrado){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", recursoNaoEncontrado.getMessage()));
    }

    @ExceptionHandler(PlacaIndisponivel.class)
    public ResponseEntity<Map<String, String>> handlePlacaIndisponivel(PlacaIndisponivel placaIndisponivel){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("erro", placaIndisponivel.getMessage()));
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Map<String, String>> handleRegraDeNegocio(RegraDeNegocioException regraDeNegocio){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_CONTENT)
                .body(Map.of("erro", regraDeNegocio.getMessage()));
    }
}
