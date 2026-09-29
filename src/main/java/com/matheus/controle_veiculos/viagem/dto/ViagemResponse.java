package com.matheus.controle_veiculos.viagem.dto;

import com.matheus.controle_veiculos.veiculo.dto.VeiculoResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Dados de resposta da API sobre a viagem")
public record ViagemResponse(

        @Schema(
                description = "Identificador único da viagem",
                example = "1"
        )
        Long viagemId,

        @Schema(
                description = "Data em que a viagem ocorreu",
                defaultValue = "2025-07-19"
        )
        LocalDate data,

        @Schema (
                description = "Valor de referência inicial em quilometros que o veículo marca em seu painel",
                defaultValue = "0"
        )
        Long quilometragemInicial,

        @Schema (
                description = "Valor de referência final em quilometros que o veículo marca em seu painel",
                defaultValue = "100"
        )
        Long quilometragemFinal,

        @Schema (
                description = "Distância que o veículo percorreu em quilometros",
                defaultValue = "100"
        )
        Long distancia,

        @Schema (
                description = "Veículo que registrou a viagem"
        )
        VeiculoResponse veiculo
) {
}
