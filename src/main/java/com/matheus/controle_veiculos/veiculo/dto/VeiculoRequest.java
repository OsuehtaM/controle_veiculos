package com.matheus.controle_veiculos.veiculo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados necessários para cadastrar ou atualizar um veículo")
public record VeiculoRequest(

        @Schema(
                description = "Marca do veículo",
                example = "Volkswagen"
        )
        @NotBlank(message = "Veículo precisa de uma marca")
        String marca,

        @Schema(
                description = "Modelo do veículo",
                example = "Gol"
        )
        @NotBlank(message = "Veículo precisa de um modelo")
        String modelo,

        @Schema(
                description = "Placa do veículo",
                example = "AAA1A11"
        )
        @NotBlank(message = "Veículo precisa de uma placa")
        @Size(max = 7, message = "Placa com formato inválido")
        String placa
) {}
