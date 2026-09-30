package com.matheus.controle_veiculos.gasto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Schema(description = "Dados necessários para cadastrar um gasto")
public record GastoRequest (

        @Schema(
                description = "Descrição do gasto",
                example = "Manutenção preventiva"
        )
        @Size(max = 255, message = "A descrição deve possuir no máximo 255 caracteres")
        String descricao,

        @Schema(
                description = "Valor do gasto",
                example = "200"
        )
        @NotNull(message = "O gasto precisa ter um valor em reais")
        @Positive(message = "O valor do gasto precisa ser positivo")
        @Digits(
                integer = 8,
                fraction = 2,
                message = "O valor do gasto deve possuir até 8 inteiros e 2 casas decimais"
        )
        BigDecimal valor,

        @Schema(
                description = "Identificador da viagem em que o gasto foi feito",
                example = "1"
        )
        @NotNull(message = "O gasto precisa ter sido feito em uma viagem")
        @Positive(message = "ID da viagem precisa ser válida")
        Long viagemId

) {
}
