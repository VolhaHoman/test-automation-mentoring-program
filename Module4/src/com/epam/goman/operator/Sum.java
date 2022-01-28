package com.epam.goman.operator;

public class Sum implements Operator {

    @Override
    public Number operate(Number x, Number y) {
        return x.doubleValue() + y.doubleValue();
    }
}
