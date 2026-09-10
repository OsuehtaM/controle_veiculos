package com.matheus.controle_veiculos.veiculo;

import com.matheus.controle_veiculos.veiculo.dto.VeiculoRequest;
import com.matheus.controle_veiculos.veiculo.dto.VeiculoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponse> save (@RequestBody @Valid VeiculoRequest request){
        VeiculoResponse response = service.save(request);

        URI uri = URI.create("/veiculos/" + response.veiculoId());

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> getAll () {
        List<VeiculoResponse> response = service.getAll();

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> getById (@PathVariable Long id){
        VeiculoResponse response = service.getById(id);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> update (@PathVariable Long id, @RequestBody @Valid VeiculoRequest request){
        VeiculoResponse response = service.update(request, id);

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
