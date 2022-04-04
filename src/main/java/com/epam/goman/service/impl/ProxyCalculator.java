package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.operator.Operator;
import com.epam.goman.service.Calculator;
import com.epam.goman.service.History;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyCalculator implements Calculator, History {

    private Map<Formula, Number> cache = new HashMap<>();

    private Calculator calculator;
    private List<Formula> history = new ArrayList<>();

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Number calculate(Formula formula) {
        history.add(formula);

        Number calculate = cache.get(formula);

        if (calculate != null){
            System.out.println("Cached value: " + calculate);
            return calculate;
        }
        calculate = calculator.calculate(formula);
        cache.put(formula, calculate);
        return calculate;
    }

    @Override
    public void addOperator(Operator operator) {
        calculator.addOperator(operator);
    }

    @Override
    public Formula getLast(int number) {
        if (history.size() < number || number <= 0) {
            throw new IndexOutOfBoundsException("History value with requested number " + number + " is not found");
        }
        return history.get(number - 1);
    }
}
