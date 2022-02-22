package com.epam.goman.service;

import com.epam.goman.model.Formula;
import com.epam.goman.operator.Operator;

public interface Calculator {

    Number calculate(Formula formula);
    void addOperator(Operator operator);
}
