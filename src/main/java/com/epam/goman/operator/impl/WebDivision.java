package com.epam.goman.operator.impl;

import com.epam.goman.service.WebCalculatorService;

public class WebDivision extends WebCalculatorOperatorAbstract {

    @Override
    public String getOperatorValue() {
        return "/";
    }
}
