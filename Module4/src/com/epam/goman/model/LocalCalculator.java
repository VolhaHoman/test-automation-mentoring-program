package com.epam.goman.model;

import com.epam.goman.operator.*;
import com.epam.goman.validator.Validator;

public class LocalCalculator implements Calculator {

    public Number calculate(Formula formula, Validator validator) throws Exception {

        validator.validate(formula);

        Operator operator = chooseOperator(formula.getOperator());
        return operator.operate(formula.getX(), formula.getY());
    }

    private Operator chooseOperator(String operator) throws Exception {

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
        throw new Exception("Result exception: Invalid operator");
    }
}
