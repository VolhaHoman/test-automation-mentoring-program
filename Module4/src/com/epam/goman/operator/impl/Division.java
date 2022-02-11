package com.epam.goman.operator.impl;

import com.epam.goman.operator.Operator;

public class Division implements Operator {


    @Override
    public Number operate(Number x, Number y) {

        if (y.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }

        double xResult = x.doubleValue();
        double yResult = y.doubleValue();
        return xResult / yResult;
    }

    @Override
    public String getOperatorValue() {
        return "/";
    }
}
