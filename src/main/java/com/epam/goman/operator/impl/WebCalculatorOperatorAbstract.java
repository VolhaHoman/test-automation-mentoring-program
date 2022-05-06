package com.epam.goman.operator.impl;

import com.epam.goman.operator.Operator;
import com.epam.goman.service.WebCalculatorService;
import com.epam.goman.service.impl.WebCalculatorServiceImpl;

public abstract class WebCalculatorOperatorAbstract implements Operator {

    private final WebCalculatorService service;

    public WebCalculatorOperatorAbstract() {
        this.service = new WebCalculatorServiceImpl();
    }

    @Override
    public Number operate(Number x, Number y) {
        return service.webOperation(x, y, getOperatorValue());
    }

    @Override
    public abstract String getOperatorValue();
}
