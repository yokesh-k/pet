package com.itvedant.petstore.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileValidator 
        implements ConstraintValidator<Mobile, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        boolean condition = value.length() == 10 && value.matches("[0-9]+");
        return condition;
    }
}
