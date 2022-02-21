package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;
import com.epam.goman.service.Calculator;

import java.util.HashMap;
import java.util.Map;

public class LocalCalculator implements Calculator {

    private Map<String, Operator> operators = new HashMap<>();

    public void addOperator(Operator operator) throws ParameterIsNullException {
        if (operator == null) {
            throw new ParameterIsNullException("Operator exception: Operator can't be null");
        }
        this.operators.put(operator.getOperatorValue(), operator);
    }

    public Number calculate(Formula formula) throws ParameterIsNullException {

        validate(formula);

        Operator operator = chooseOperator(formula.getOperator());
        return operator.operate(formula.getX(), formula.getY());
    }

    private Operator chooseOperator(String operator) {
        if (operators.containsKey(operator)) {
            return operators.get(operator);
        }
        throw new IllegalArgumentException("Operator not found");
    }

    private void validate(Formula formula) throws ParameterIsNullException {

        if (formula.getX() == null) {
            throw new ParameterIsNullException("Formula exception: Parameter x can't be null");
        }
        if (formula.getY() == null) {
            throw new ParameterIsNullException("Formula exception: Parameter y can't be null");
        }
        if (formula.getOperator() == null || formula.getOperator().isBlank()) {
            throw new ParameterIsNullException("Formula exception: Operator can't be null or empty");
        }
    }
}
