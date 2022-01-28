package com.epam.goman.validator;

import com.epam.goman.model.Formula;

public interface Validator {

    void validate (Formula formula) throws Exception;
}
