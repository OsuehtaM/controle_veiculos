package com.matheus.controle_veiculos.veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculo_id")
    private Long veiculoId;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 7, unique = true)
    private String placa;
}
