package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.OperatorNotFoundException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.Operator;
import com.epam.goman.operator.impl.Sum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocalCalculatorTest {

    @Test
    @DisplayName("Check add operator")
    void addOperator() throws NoSuchFieldException, IllegalAccessException {
        LocalCalculator localCalculator = new LocalCalculator();
        localCalculator.addOperator(new Sum());
        Field operators = localCalculator.getClass().getDeclaredField("operators");
        operators.setAccessible(true);
        Map<String, Operator> operatorsResult = (Map<String, Operator>) operators.get(localCalculator);

        Operator operator = operatorsResult.get("+");
        assertEquals(operator.getClass(), Sum.class);
    }

    @Test
    @DisplayName("Check positive calculate")
    void calculate() {
        LocalCalculator calculator = new LocalCalculator();
        calculator.addOperator(new Sum());
        Number calculate = calculator.calculate(new Formula(5, 4, "+"));
        assertEquals(9.0, calculate);
    }

    @Test
    @DisplayName("Check not found operator")
    void calculateOperatorNotFoundException() {
        LocalCalculator calculator = new LocalCalculator();

        assertThrows(OperatorNotFoundException.class, () -> {
            Number calculate = calculator.calculate(new Formula(5, 4, "+"));
        });

    }

    @Test
    @DisplayName("Check operator is null")
    void calculateParameterIsNullException() {
        LocalCalculator calculator = new LocalCalculator();

        assertThrows(ParameterIsNullException.class, () -> {
            calculator.addOperator(null);
        });

    }

}
