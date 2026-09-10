package com.matheus.controle_veiculos.veiculo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidator implements ConstraintValidator<PlacaValida, String> {

    private static final String REGEX = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$";

    @Override
    public boolean isValid(
            String placa,
            ConstraintValidatorContext context
    ) {
        if (placa == null) {
            return true;
        }

        return placa.toUpperCase().matches(REGEX);
    }
}
