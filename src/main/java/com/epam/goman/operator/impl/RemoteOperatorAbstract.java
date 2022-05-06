package com.epam.goman.operator.impl;

import com.epam.goman.operator.Operator;
import com.epam.goman.service.MathJsService;
import com.epam.goman.service.impl.MathJsServiceImpl;

public abstract class RemoteOperatorAbstract implements Operator {

    private final MathJsService service;

    public RemoteOperatorAbstract() {
        this.service = new MathJsServiceImpl();
    }

    @Override
    public Number operate(Number x, Number y) {
        return service.httpRequest(x, y, getOperatorValue());
    }

    @Override
    public abstract String getOperatorValue();
}
