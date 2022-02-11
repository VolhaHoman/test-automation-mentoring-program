package com.epam.goman.service;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;

public interface Calculator {

    Number calculate(Formula formula) throws ParameterIsNullException, InvalidOperatorException;
    void addOperator(Operator operator) throws ParameterIsNullException;
}
