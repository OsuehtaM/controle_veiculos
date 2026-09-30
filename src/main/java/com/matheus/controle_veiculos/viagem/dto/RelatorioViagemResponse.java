package com.matheus.controle_veiculos.viagem.dto;

import java.math.BigDecimal;

public record RelatorioViagemResponse(

        Long viagemId,
        BigDecimal totalOutrosGastos,
        BigDecimal totalGastoCombustivel,
        BigDecimal custoTotal,
        BigDecimal custoPorQuilometro
) {
}
