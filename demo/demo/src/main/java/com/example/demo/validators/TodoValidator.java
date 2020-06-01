package com.example.demo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TodoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
