package com.matheus.controle_veiculos.veiculo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlacaValidator.class)
@Target({
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.RECORD_COMPONENT
})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValida {

    String message() default "Placa com formato inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
