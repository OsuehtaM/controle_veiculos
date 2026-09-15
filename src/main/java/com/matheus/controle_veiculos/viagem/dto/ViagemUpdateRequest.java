package com.matheus.controle_veiculos.viagem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record ViagemUpdateRequest (

        @Schema(
                description = "Data em que a viagem ocorreu",
                defaultValue = "2025-07-19"
        )
        @NotNull(message = "A viagem precisa de uma data")
        @PastOrPresent(message = "A viagem precisa estar acontecendo, ou já ter acontecido")
        LocalDate data,

        @Schema (
                description = "Valor de referência inicial em quilometros que o veículo marca em seu painel",
                defaultValue = "0"
        )
        @NotNull(message = "A viagem precisa ter uma quilometragem inicial")
        @PositiveOrZero(message = "O valor da quilometragem inicial precisa ser positivo ou zero")
        Long quilometragemInicial,

        @Schema (
                description = "Valor de referência final em quilometros que o veículo marca em seu painel",
                defaultValue = "100"
        )
        @Positive(message = "O valor final da quilometragem precisa ser positivo")
        Long quilometragemFinal
) {
}
