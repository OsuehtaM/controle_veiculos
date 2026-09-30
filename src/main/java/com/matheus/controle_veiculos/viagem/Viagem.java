package com.matheus.controle_veiculos.viagem;

import com.matheus.controle_veiculos.exception.RegraDeNegocioException;
import com.matheus.controle_veiculos.gasto.Gasto;
import com.matheus.controle_veiculos.reabastecimento.Reabastecimento;
import com.matheus.controle_veiculos.veiculo.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "viagens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viagem_id")
    private Long viagemId;

    @NotNull
    private LocalDate data;

    @Column(name = "quilometragem_inicial")
    @NotNull
    private Long quilometragemInicial;

    @Column(name = "quilometragem_final")
    private Long quilometragemFinal;

    private Long distancia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @OneToMany(mappedBy = "viagem")
    private List<Reabastecimento> reabastecimentos = new ArrayList<>();

    @OneToMany(mappedBy = "viagem")
    private List<Gasto> gastos = new ArrayList<>();

    public void calcularDistancia () {
        if (quilometragemFinal <= quilometragemInicial){
            throw new RegraDeNegocioException("A quilometragem final precisa ser superior à inicial");
        }
        this.distancia = quilometragemFinal - quilometragemInicial;
    }
}
