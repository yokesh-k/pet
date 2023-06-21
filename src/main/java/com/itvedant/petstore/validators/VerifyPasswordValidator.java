package com.itvedant.petstore.validators;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerifyPasswordValidator 
    implements ConstraintValidator<VerifyPassword, Object> {
        private String field;
        private String matchingField;

    @Override
    public void initialize(VerifyPassword constraintAnnotation) {
        //field will get the value as password
        this.field = constraintAnnotation.field();
        //matchingField will get the value confirmPassword
        this.matchingField = constraintAnnotation.matchingField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext arg1) {
        //will get the value of the password field/variable
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        //will get the value of the confirmPassword field/variable
        Object matchingFieldValue = new BeanWrapperImpl(value).getPropertyValue(matchingField);

        return fieldValue.equals(matchingFieldValue);
    }
}
