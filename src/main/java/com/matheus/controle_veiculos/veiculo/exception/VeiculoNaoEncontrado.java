package com.matheus.controle_veiculos.veiculo.exception;

public class VeiculoNaoEncontrado extends RuntimeException {
    public VeiculoNaoEncontrado() {
        super("Veículo não encontrado.");
    }
}
