package com.matheus.controle_veiculos.gasto;

import com.matheus.controle_veiculos.exception.RecursoNaoEncontradoException;
import com.matheus.controle_veiculos.gasto.dto.GastoRequest;
import com.matheus.controle_veiculos.gasto.dto.GastoResponse;
import com.matheus.controle_veiculos.gasto.dto.GastoUpdateRequest;
import com.matheus.controle_veiculos.viagem.Viagem;
import com.matheus.controle_veiculos.viagem.ViagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GastoService {

    private final GastoRepository repository;
    private final ViagemRepository viagemRepository;
    private final GastoMapper mapper;

    @Transactional
    public GastoResponse save (GastoRequest request){

        Viagem viagem = viagemRepository.findById(request.viagemId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", request.viagemId()));

        Gasto entity = mapper.toEntity(request);

        entity.setViagem(viagem);

        Gasto savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public List<GastoResponse> getAll(){
        List<Gasto> response = repository.findAll();

        return response.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public GastoResponse getById (Long id){
        Gasto entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Gasto", id));

        return mapper.toResponse(entity);
    }

    @Transactional
    public GastoResponse update (Long id, GastoUpdateRequest request){
        Gasto entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Gasto", id));

        entity.setDescricao(request.descricao());
        entity.setValor(request.valor());

        Gasto savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    @Transactional
    public void delete (Long id){

        if (!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Gasto", id);
        }

        repository.deleteById(id);
    }
}
