package com.matheus.controle_veiculos.reabastecimento.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resumo do reabastecimento sem os dados da viagem")
public record ReabastecimentoResumoResponse(

        @Schema(
                description = "Identificador único do reabastecimento",
                example = "1"
        )
        Long reabastecimentoId,

        @Schema(
                description = "Quantidade de litros abastecidos",
                example = "10"
        )
        BigDecimal quantidadeAbastecida,

        @Schema(
                description = "Valor em reais do custo do litro no local de reabastecimento",
                example = "5"
        )
        BigDecimal valorLitro

) {
}
