package com.matheus.controle_veiculos.viagem;

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
