package com.matheus.controle_veiculos.reabastecimento;

import com.matheus.controle_veiculos.exception.RecursoNaoEncontradoException;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoRequest;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoResponse;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoUpdateRequest;
import com.matheus.controle_veiculos.viagem.Viagem;
import com.matheus.controle_veiculos.viagem.ViagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReabastecimentoService {

    private final ReabastecimentoRepository repository;
    private final ViagemRepository viagemRepository;
    private final ReabastecimentoMapper mapper;

    @Transactional
    public ReabastecimentoResponse save (ReabastecimentoRequest request){

        Viagem viagem = viagemRepository.findById(request.viagemId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", request.viagemId()));

        Reabastecimento entity = mapper.toEntity(request);

        entity.setViagem(viagem);

        Reabastecimento savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    public List<ReabastecimentoResponse> getAll(){
        List<Reabastecimento> response = repository.findAll();

        return response.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ReabastecimentoResponse getById (Long id){
        Reabastecimento entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Reabastecimento", id));

        return mapper.toResponse(entity);
    }

    @Transactional
    public ReabastecimentoResponse update (Long id, ReabastecimentoUpdateRequest request){
        Reabastecimento entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Reabastecimento", id));

        entity.setValorLitro(request.valorLitro());
        entity.setQuantidadeAbastecida(request.quantidadeAbastecida());

        Reabastecimento savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    @Transactional
    public void delete (Long id){

        if (!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Reabastecimento", id);
        }

        repository.deleteById(id);
    }
}
