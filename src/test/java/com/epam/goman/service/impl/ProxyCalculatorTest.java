package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.operator.impl.Sum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProxyCalculatorTest {

    @Test
    @DisplayName("Check get last formula")
    void getLast() {
        ProxyCalculator proxy = new ProxyCalculator(new LocalCalculator());
        proxy.addOperator(new Sum());
        Formula formula = new Formula(5, 4, "+");
        Number calculate = proxy.calculate(formula);
        assertEquals(formula, proxy.getLast(1));
    }

    @Test
    @DisplayName("Check get last formula")
    void getLastCache() {
        LocalCalculator mock = Mockito.mock(LocalCalculator.class);
        ProxyCalculator proxy = new ProxyCalculator(mock);
        proxy.addOperator(new Sum());
        Formula formula = new Formula(5, 4, "+");
        Mockito.when(mock.calculate(formula)).thenReturn(9);
        Number calculate = proxy.calculate(formula);
        Number calculate2 = proxy.calculate(formula);
        Mockito.verify(mock, Mockito.times(1)).calculate(formula);
    }

    @Test
    @DisplayName("Check history value not found")
    void getLastNotFound() {
        ProxyCalculator proxy = new ProxyCalculator(new LocalCalculator());
        proxy.addOperator(new Sum());
        Formula formula = new Formula(5, 4, "+");
        Number calculate = proxy.calculate(formula);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            proxy.getLast(100);
        });
    }
}
