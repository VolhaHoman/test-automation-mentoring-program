package com.epam.goman.model;

import com.epam.goman.validator.Validator;

public interface Calculator {

    Number calculate(Formula formula, Validator validator) throws Exception;
}
