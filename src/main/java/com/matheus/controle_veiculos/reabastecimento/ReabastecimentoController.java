package com.matheus.controle_veiculos.reabastecimento;

import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoRequest;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoResponse;
import com.matheus.controle_veiculos.reabastecimento.dto.ReabastecimentoUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reabastecimentos")
public class ReabastecimentoController {

    private final ReabastecimentoService service;

    @PostMapping
    public ResponseEntity<ReabastecimentoResponse> save (@RequestBody @Valid ReabastecimentoRequest request){
        ReabastecimentoResponse response = service.save(request);

        URI uri = URI.create("/reabastecimentos/" + response.reabastecimentoId());

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ReabastecimentoResponse>> getAll () {
        List<ReabastecimentoResponse> response = service.getAll();

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReabastecimentoResponse> getById (@PathVariable Long id){
        ReabastecimentoResponse response = service.getById(id);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReabastecimentoResponse> update (@PathVariable Long id, @RequestBody @Valid ReabastecimentoUpdateRequest request){
        ReabastecimentoResponse response = service.update(id, request);

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
