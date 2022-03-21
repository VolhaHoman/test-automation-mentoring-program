package com.epam.goman.operator.impl;

import com.epam.goman.operator.Operator;

public class Subtraction implements Operator {

    @Override
    public Number operate(Number x, Number y) {
        return x.doubleValue() - y.doubleValue();
    }

    @Override
    public String getOperatorValue() {
        return "-";
    }
}
