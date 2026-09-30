package com.matheus.controle_veiculos.reabastecimento;

import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoRequest;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReabastecimentoMapper {

    @Mapping(
            target = "reabastecimentoId",
            ignore = true
    )
    @Mapping(
            target = "viagem",
            ignore = true
    )
    Reabastecimento toEntity (ReabastecimentoRequest request);

    ReabastecimentoResponse toResponse (Reabastecimento entity);

}
