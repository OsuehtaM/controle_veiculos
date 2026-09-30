package com.matheus.controle_veiculos.gasto.dto;

import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados de resposta da API sobre o gasto")
public record GastoResponse(

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
        BigDecimal valor,

        @Schema(
                description = "Viagem em que o gasto foi feito"
        )
        ViagemResponse viagem

) {
}
