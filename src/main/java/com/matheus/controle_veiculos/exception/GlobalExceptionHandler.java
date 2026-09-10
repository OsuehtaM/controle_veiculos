package com.matheus.controle_veiculos.exception;

import com.matheus.controle_veiculos.veiculo.exception.PlacaIndisponivel;
import com.matheus.controle_veiculos.veiculo.exception.VeiculoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlacaIndisponivel.class)
    public ResponseEntity<Map<String, String>> handlePlacaIndisponivel(PlacaIndisponivel placaIndisponivel){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("erro", placaIndisponivel.getMessage()));
    }

    @ExceptionHandler(VeiculoNaoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleVeiculoNaoEncontrado(VeiculoNaoEncontrado veiculoNaoEncontrado){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", veiculoNaoEncontrado.getMessage()));
    }
}
