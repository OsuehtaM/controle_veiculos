package com.matheus.controle_veiculos.gasto.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resumo do gasto sem os dados da viagem")
public record GastoResumoResponse(

        @Schema(
                description = "Identificador único do gasto",
                example = "1"
        )
        Long gastoId,

        @Schema(
                description = "Descrição do gasto",
                example = "Manutenção preventiva"
        )
        String descricao,

        @Schema(
                description = "Valor do gasto",
                example = "200"
        )
        BigDecimal valor

) {
}
