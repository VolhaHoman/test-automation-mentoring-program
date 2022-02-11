package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;
import com.epam.goman.service.Calculator;

import java.util.*;

public class LocalCalculator implements Calculator {

    private List <Operator> operators = new ArrayList<>();

    public void addOperator(Operator operator) throws ParameterIsNullException {
        if (operator == null) {
            throw new ParameterIsNullException("Operator exception: Operator can't be null");
        }
        this.operators.add(operator);
    }

    public Number calculate(Formula formula) throws ParameterIsNullException, InvalidOperatorException {

        validate(formula);

        Operator operator = chooseOperator(formula.getOperator());
        return operator.operate(formula.getX(), formula.getY());
    }

    private Operator chooseOperator (String operator) throws InvalidOperatorException {

        Iterator<Operator> iterator = operators.iterator();

        while (iterator.hasNext()){
            Operator next = iterator.next();
            if (next.getOperatorValue().equals(operator)){
                return next;
            }
        }

        throw new InvalidOperatorException("Operator not found");
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
