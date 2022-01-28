package com.epam.goman.operator;

public class Subtraction implements Operator {

    @Override
    public Number operate(Number x, Number y) {
        return x.doubleValue() - y.doubleValue();
    }
}
