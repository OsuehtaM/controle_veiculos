package com.matheus.controle_veiculos.gasto;

import com.matheus.controle_veiculos.gasto.dto.GastoRequest;
import com.matheus.controle_veiculos.gasto.dto.GastoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GastoMapper {

    @Mapping(
            target = "gastoId",
            ignore = true
    )
    @Mapping(
            target = "viagem",
            ignore = true
    )
    Gasto toEntity (GastoRequest request);

    GastoResponse toResponse (Gasto entity);
}
