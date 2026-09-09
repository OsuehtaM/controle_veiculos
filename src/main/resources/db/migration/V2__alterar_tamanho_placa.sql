ALTER TABLE veiculos
ALTER COLUMN placa TYPE VARCHAR(7);

ALTER TABLE veiculos
ADD CONSTRAINT chk_placa_tamanho
CHECK (char_length(placa) =7);