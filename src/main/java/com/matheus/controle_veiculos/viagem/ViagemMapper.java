package com.matheus.controle_veiculos.viagem;

import com.matheus.controle_veiculos.viagem.dto.ViagemRequest;
import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ViagemMapper {

    @Mapping(
            target = "viagemId",
            ignore = true
    )
    @Mapping(
            target = "distancia",
            ignore = true
    )
    @Mapping(
            target = "veiculo",
            ignore = true
    )
    Viagem toEntity (ViagemRequest request);

    ViagemResponse toResponse (Viagem entity);
}
