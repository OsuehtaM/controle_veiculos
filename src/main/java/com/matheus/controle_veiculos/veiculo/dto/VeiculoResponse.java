package com.matheus.controle_veiculos.veiculo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta da API sobre o veículo")
public record VeiculoResponse(

        @Schema(
                description = "Identificador único de veículo",
                example = "1"
        )
        Long veiculoId,

        @Schema(
                description = "Marca do veículo",
                example = "Volkswagen"
        )
        String marca,

        @Schema(
                description = "Modelo do veículo",
                example = "Gol"
        )
        String modelo,

        @Schema(
                description = "Placa do veículo",
                example = "AAA1A11"
        )
        String placa
) {}
