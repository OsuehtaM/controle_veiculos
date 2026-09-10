package com.matheus.controle_veiculos.veiculo;

import com.matheus.controle_veiculos.veiculo.dto.VeiculoRequest;
import com.matheus.controle_veiculos.veiculo.dto.VeiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mapping(
            target = "veiculoId",
            ignore = true
    )
    @Mapping(
            target = "placa",
            expression = "java(request.placa().toUpperCase())"
    )
    Veiculo toEntity(VeiculoRequest request);

    VeiculoResponse toResponse (Veiculo entity);
}
