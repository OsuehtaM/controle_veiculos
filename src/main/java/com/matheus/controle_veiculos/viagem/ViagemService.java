package com.matheus.controle_veiculos.viagem;

import com.matheus.controle_veiculos.exception.RecursoNaoEncontradoException;
import com.matheus.controle_veiculos.veiculo.Veiculo;
import com.matheus.controle_veiculos.veiculo.VeiculoRepository;
import com.matheus.controle_veiculos.viagem.dto.ViagemRequest;
import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import com.matheus.controle_veiculos.viagem.dto.ViagemUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViagemService {

    private final ViagemRepository repository;
    private final VeiculoRepository veiculoRepository;
    private final ViagemMapper mapper;

    public ViagemResponse save (ViagemRequest request){

        Veiculo veiculo = veiculoRepository.findById(request.veiculoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veiculo", request.veiculoId()));

        Viagem entity = mapper.toEntity(request);

        entity.setVeiculo(veiculo);

        if (request.quilometragemFinal() != null){
            entity.calcularDistancia();
        }
        
        Viagem savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public List<ViagemResponse> getAll(){
        List<Viagem> response = repository.findAll();

        return response.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ViagemResponse getById (Long id){
        Viagem entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", id));

        return mapper.toResponse(entity);
    }

    public ViagemResponse update (Long id, ViagemUpdateRequest request){
        Viagem entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", id));

        entity.setData(request.data());
        entity.setQuilometragemInicial(request.quilometragemInicial());
        entity.setQuilometragemFinal(request.quilometragemFinal());

        if (request.quilometragemFinal() != null){
            entity.calcularDistancia();
        }else{
            entity.setDistancia(null);
        }

        Viagem savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }
    public void delete (Long id){

        if (!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Viagem", id);
        }

        repository.deleteById(id);
    }
}
