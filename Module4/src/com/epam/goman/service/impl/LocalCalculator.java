package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;
import com.epam.goman.operator.impl.Division;
import com.epam.goman.operator.impl.Multiply;
import com.epam.goman.operator.impl.Subtraction;
import com.epam.goman.operator.impl.Sum;
import com.epam.goman.service.Calculator;

public class LocalCalculator implements Calculator {

    public Number calculate(Formula formula) throws ParameterIsNullException, InvalidOperatorException {

        validate(formula);

        Operator operator = chooseOperator(formula.getOperator());
        return operator.operate(formula.getX(), formula.getY());
    }

    private Operator chooseOperator(String operator) throws InvalidOperatorException {

        if ("*".equals(operator)) {
            return new Multiply();
        }
        if ("/".equals(operator)) {
            return new Division();
        }
        if ("+".equals(operator)) {
            return new Sum();
        }
        if ("-".equals(operator)) {
            return new Subtraction();
        }
        throw new InvalidOperatorException("Result exception: Invalid operator");
    }

    private void validate(Formula formula) throws ParameterIsNullException {

        if (formula.getX() == null) {
            throw new ParameterIsNullException("Formula exception: Parameter x can't be null");
        }
        if (formula.getY() == null) {
            throw new ParameterIsNullException("Formula exception: Parameter y can't be null");
        }
        if (formula.getOperator() == null || formula.getOperator().isBlank()){
            throw new ParameterIsNullException("Formula exception: Operator can't be null or empty");
        }
    }
}
