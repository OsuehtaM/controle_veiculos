package com.matheus.controle_veiculos.reabastecimento.dto;

import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados de resposta da API sobre o reabastecimento")
public record ReabastecimentoResponse(

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
        BigDecimal valorLitro,

        @Schema(
                description = "Viagem em que o reabastecimento foi feito"
        )
        ViagemResponse viagem

) {
}
