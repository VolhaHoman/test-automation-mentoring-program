package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;
import com.epam.goman.service.Calculator;
import com.epam.goman.service.History;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyCalculator implements Calculator, History {

    private Map<Formula, Number> cacheMap = new HashMap<>();

    private Calculator calculator;
    private List<Number> historyList = new ArrayList<>();

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Number calculate(Formula formula) throws ParameterIsNullException, InvalidOperatorException {

        Number calculate = null;
        if (cacheMap.containsKey(formula)) {
            System.out.println("Cached value:");
            calculate = cacheMap.get(formula);
        } else {
            calculate = calculator.calculate(formula);
            cacheMap.put(formula, calculate);
        }
        historyList.add(calculate);
        return calculate;
    }

    @Override
    public void addOperator(Operator operator) throws ParameterIsNullException {
        calculator.addOperator(operator);
    }

    @Override
    public Number getLast(int number) throws InvalidOperatorException {
        if (historyList.size() < number || number <= 0) {
            throw new InvalidOperatorException("History value with requested number:" + number + " not found");
        }
        return historyList.get(number - 1);
    }
}
