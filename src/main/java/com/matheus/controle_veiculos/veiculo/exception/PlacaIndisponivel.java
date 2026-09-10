package com.matheus.controle_veiculos.veiculo.exception;

public class PlacaIndisponivel extends RuntimeException {

    public PlacaIndisponivel(String placa) {
        super("A placa " + placa + " já está cadastrada em outro veículo");
    }
}
