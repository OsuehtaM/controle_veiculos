CREATE TABLE veiculos (
    veiculo_id BIGSERIAL PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    placa VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE viagens (
    viagem_id BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    quilometragem_inicial BIGINT NOT NULL,
    quilometragem_final BIGINT,
    distancia BIGINT,
    veiculo_id BIGINT NOT NULL,

    CONSTRAINT fk_viagens_veiculo
        FOREIGN KEY (veiculo_id)
        REFERENCES veiculos(veiculo_id)
);

CREATE TABLE gastos (
    gasto_id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    valor DECIMAL(10, 2) NOT NULL,
    viagem_id BIGINT NOT NULL,

    CONSTRAINT fk_gastos_viagem
        FOREIGN KEY (viagem_id)
        REFERENCES viagens(viagem_id)
);

CREATE TABLE reabastecimentos (
    reabastecimento_id BIGSERIAL PRIMARY KEY,
    quantidade_abastecida DECIMAL(10, 2) NOT NULL,
    valor_litro DECIMAL(10, 3) NOT NULL,
    viagem_id BIGINT NOT NULL,

    CONSTRAINT fk_reabastecimentos_viagem
        FOREIGN KEY (viagem_id)
        REFERENCES viagens(viagem_id)
);