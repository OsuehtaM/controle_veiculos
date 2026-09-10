ALTER TABLE gastos
DROP CONSTRAINT fk_gastos_viagem;

ALTER TABLE gastos
ADD CONSTRAINT fk_gastos_viagem
FOREIGN KEY (viagem_id)
REFERENCES viagens(viagem_id)
ON DELETE CASCADE;

ALTER TABLE reabastecimentos
DROP CONSTRAINT fk_reabastecimentos_viagem;

ALTER TABLE reabastecimentos
ADD CONSTRAINT fk_reabastecimentos_viagem
FOREIGN KEY (viagem_id)
REFERENCES viagens(viagem_id)
ON DELETE CASCADE;

ALTER TABLE viagens
DROP CONSTRAINT fk_viagens_veiculo;

ALTER TABLE viagens
ADD CONSTRAINT fk_viagens_veiculo
FOREIGN KEY (veiculo_id)
REFERENCES veiculos(veiculo_id)
ON DELETE CASCADE;