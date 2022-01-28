package com.epam.goman.operator;

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
}
