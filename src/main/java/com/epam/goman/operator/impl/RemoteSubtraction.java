package com.epam.goman.operator.impl;

import com.epam.goman.operator.Operator;
import com.epam.goman.service.MathJsService;
import com.epam.goman.service.impl.MathJsServiceImpl;

public class RemoteSubtraction extends RemoteOperatorAbstract {

    @Override
    public String getOperatorValue() {
        return "-";
    }
}
