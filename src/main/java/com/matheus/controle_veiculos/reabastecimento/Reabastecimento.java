package com.matheus.controle_veiculos.reabastecimento;

import com.matheus.controle_veiculos.viagem.Viagem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "reabastecimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reabastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reabastecimento_id")
    private Long reabastecimentoId;

    @Column(name="quantidade_abastecida", nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidadeAbastecida;

    @Column(name="valor_litro", nullable = false, precision = 10, scale = 3)
    private BigDecimal valorLitro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "viagem_id", nullable = false)
    private Viagem viagem;
}
