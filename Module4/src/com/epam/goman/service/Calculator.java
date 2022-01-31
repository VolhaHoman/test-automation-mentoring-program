package com.epam.goman.service;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;

public interface Calculator {

    Number calculate(Formula formula) throws ParameterIsNullException, InvalidOperatorException;
}
