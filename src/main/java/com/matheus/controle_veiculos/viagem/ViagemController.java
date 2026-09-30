package com.matheus.controle_veiculos.viagem;

import com.matheus.controle_veiculos.gasto.dto.GastoResumoResponse;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoResumoResponse;
import com.matheus.controle_veiculos.viagem.dto.RelatorioViagemResponse;
import com.matheus.controle_veiculos.viagem.dto.ViagemRequest;
import com.matheus.controle_veiculos.viagem.dto.ViagemResponse;
import com.matheus.controle_veiculos.viagem.dto.ViagemUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/viagens")
public class ViagemController {

    private final ViagemService service;

    @PostMapping
    public ResponseEntity<ViagemResponse> save (@RequestBody @Valid ViagemRequest request){
        ViagemResponse response = service.save(request);

        URI uri = URI.create("/viagens/" + response.viagemId());

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ViagemResponse>> getAll () {
        List<ViagemResponse> response = service.getAll();

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViagemResponse> getById (@PathVariable Long id){
        ViagemResponse response = service.getById(id);

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}/relatorio")
    public ResponseEntity<RelatorioViagemResponse> gerarRelatorio (@PathVariable Long id){
        RelatorioViagemResponse response = service.gerarRelatorio(id);

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}/gastos")
    public ResponseEntity<List<GastoResumoResponse>> getGastos (@PathVariable Long id){
        List<GastoResumoResponse> response = service.getGastos(id);

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}/reabastecimentos")
    public ResponseEntity<List<ReabastecimentoResumoResponse>> getReabastecimentos (@PathVariable Long id){
        List<ReabastecimentoResumoResponse> response = service.getReabastecimentos(id);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViagemResponse> update (@PathVariable Long id, @RequestBody @Valid ViagemUpdateRequest request){
        ViagemResponse response = service.update(id, request);

        return ResponseEntity
                .ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
