package com.matheus.controle_veiculos.veiculo;

import com.matheus.controle_veiculos.veiculo.dto.VeiculoRequest;
import com.matheus.controle_veiculos.veiculo.dto.VeiculoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;
    private final VeiculoMapper mapper;

    public VeiculoResponse save (VeiculoRequest request){

        if ( repository.existsByPlaca(request.placa().toUpperCase())){
            throw new RuntimeException("Placa indisponível");
        }

        Veiculo entity = mapper.toEntity(request);

        Veiculo savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public List<VeiculoResponse> getAll (){
        List<Veiculo> entityList = repository.findAll();

        return entityList.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public VeiculoResponse getById (Long id){

        Veiculo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado."));

        return mapper.toResponse(entity);
    }

    public VeiculoResponse update (VeiculoRequest request, Long id){

        Veiculo entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado."));

        String placa = request.placa().toUpperCase();

        if (!placa.equals(entity.getPlaca())){

            if ( repository.existsByPlaca(placa)){
                throw new RuntimeException("Placa indisponível");
            }
        }

        entity.setMarca(request.marca());
        entity.setModelo(request.modelo());
        entity.setPlaca(placa);

        Veiculo savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public void delete (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Veículo não encontrado.");
        }

        repository.deleteById(id);
    }
}
