package com.matheus.controle_veiculos.reabastecimento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = "Dados necessários para cadastrar um reabastecimento")
public record ReabastecimentoRequest(

        @Schema(
                description = "Quantidade de litros abastecidos",
                example = "10"
        )
        @NotNull(message = "Reabastecimento precisa de uma quantidade abastecida em litros")
        @Positive(message = "A quantidade abastecida precisa ser positiva")
        @Digits(
                integer = 8,
                fraction = 2,
                message = "A quantidade deve possuir até 8 inteiros e 2 casas decimais"
        )
        BigDecimal quantidadeAbastecida,

        @Schema(
                description = "Valor em reais do custo do litro no local de reabastecimento",
                example = "5"
        )
        @NotNull(message = "Reabastecimento precisa de um valor do combustível em real")
        @Positive(message = "O valor do litro precisa ser positivo")
        @Digits(
                integer = 7,
                fraction = 3,
                message = "O valor do litro deve possuir até 7 inteiros e 3 casas decimais"
        )
        BigDecimal valorLitro,

        @Schema(
                description = "Identificador da viagem em que o reabastecimento foi feito",
                example = "1"
        )
        @NotNull(message = "O reabastecimento precisa ter sido feito em uma viagem")
        @Positive(message = "ID da viagem precisa ser válida")
        Long viagemId
) {
}
