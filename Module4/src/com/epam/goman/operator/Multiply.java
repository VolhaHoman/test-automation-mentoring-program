package com.epam.goman.operator;

public class Multiply implements Operator {

    @Override
    public Number operate(Number x, Number y) {

        double xResult = x.doubleValue();
        double yResult = y.doubleValue();
        return xResult * yResult;
    }
}
