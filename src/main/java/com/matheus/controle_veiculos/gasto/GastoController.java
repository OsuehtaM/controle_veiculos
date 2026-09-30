package com.matheus.controle_veiculos.gasto;

import com.matheus.controle_veiculos.gasto.dto.GastoRequest;
import com.matheus.controle_veiculos.gasto.dto.GastoResponse;
import com.matheus.controle_veiculos.gasto.dto.GastoUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService service;

    @PostMapping
    public ResponseEntity<GastoResponse> save (@RequestBody @Valid GastoRequest request){
        GastoResponse response = service.save(request);

        URI uri = URI.create("/gastos/" + response.gastoId());

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<GastoResponse>> getAll () {
        List<GastoResponse> response = service.getAll();

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoResponse> getById (@PathVariable Long id){
        GastoResponse response = service.getById(id);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoResponse> update (@PathVariable Long id, @RequestBody @Valid GastoUpdateRequest request){
        GastoResponse response = service.update(id, request);

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
