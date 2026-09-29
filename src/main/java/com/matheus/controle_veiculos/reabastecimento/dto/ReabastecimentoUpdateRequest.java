package com.matheus.controle_veiculos.reabastecimento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = "Dados necessários para atualizar um reabastecimento")
public record ReabastecimentoUpdateRequest(

        @Schema(
                description = "Quantidade de litros abastecidos",
                example = "10"
        )
        @NotNull(message = "Reabastecimento precisa de uma quantidade abastecida em litros")
        @Positive(message = "A quantidade abastecida precisa ser positiva")
        BigDecimal quantidadeAbastecida,

        @Schema(
                description = "Valor em reais do custo do litro no local de reabastecimento",
                example = "5"
        )
        @NotNull(message = "Reabastecimento precisa de um valor do combustível em real")
        @Positive(message = "O valor do litro precisa ser positivo")
        BigDecimal valorLitro

) {
}
