package com.matheus.controle_veiculos.viagem;

import com.matheus.controle_veiculos.exception.RecursoNaoEncontradoException;
import com.matheus.controle_veiculos.gasto.GastoMapper;
import com.matheus.controle_veiculos.gasto.dto.GastoResumoResponse;
import com.matheus.controle_veiculos.reabastecimento.ReabastecimentoMapper;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoResumoResponse;
import com.matheus.controle_veiculos.veiculo.Veiculo;
import com.matheus.controle_veiculos.veiculo.VeiculoRepository;
import com.matheus.controle_veiculos.viagem.dto.RelatorioViagemResponse;
import com.matheus.controle_veiculos.viagem.dto.ViagemRequest;
import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import com.matheus.controle_veiculos.viagem.dto.ViagemUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ViagemService {

    private final ViagemRepository repository;
    private final VeiculoRepository veiculoRepository;
    private final ViagemMapper mapper;
    private final GastoMapper gastoMapper;
    private final ReabastecimentoMapper reabastecimentoMapper;

    @Transactional
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

    public RelatorioViagemResponse gerarRelatorio (Long id){
        Viagem viagem = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Viagem", id)
                );

        BigDecimal totalOutrosGastos = viagem.calcularGastos();
        BigDecimal totalCombustivel =
                viagem.calcularGastosCombustivel();

        return new RelatorioViagemResponse(
                id,
                totalOutrosGastos,
                totalCombustivel,
                totalOutrosGastos.add(totalCombustivel),
                viagem.calcularCustoPorQuilometro()
        );
    }

    public List<GastoResumoResponse> getGastos (Long id){
        Viagem entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", id));

        return entity.getGastos()
                .stream()
                .map(gastoMapper::toResumoResponse)
                .toList();
    }

    public List<ReabastecimentoResumoResponse> getReabastecimentos (Long id){
        Viagem entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Viagem", id));

        return entity.getReabastecimentos()
                .stream()
                .map(reabastecimentoMapper::toResumoResponse)
                .toList();
    }

    @Transactional
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

    @Transactional
    public void delete (Long id){

        if (!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Viagem", id);
        }

        repository.deleteById(id);
    }
}
