package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @ParameterizedTest
    @CsvSource({"8, 2, 4", "4.20, 1.05, 4.0"})
    @DisplayName("Positive Division check")
    void operatePositive(Double x, Double y, Double result) {
        Division divisionOperate = new Division();
        Number operate = divisionOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative Division null check")
    void operateNegativeNull(Number x, Number y) {
        Division divisionOperate = new Division();
        assertThrows(NullPointerException.class, () -> {
            Number operate = divisionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Negative Division max check")
    void operateNegativeMax(Number x, Number y, Number result) {
        Division divisionOperate = new Division();
        Number operate = divisionOperate.operate(x, y);
        assertEquals(result, operate);
    }

    @Test
    @DisplayName("Negative Division by zero check")
    void operateNegativeZero() {
        Division divisionOperate = new Division();
        assertThrows(ArithmeticException.class, () -> {
            Number operate = divisionOperate.operate(5, 0);
        });
    }

    @Test
    @DisplayName("Check correct value of Division get operator value")
    void getOperatorValue() {
        Division division = new Division();
        assertEquals("/", division.getOperatorValue());
    }

    private static Stream<Arguments> provideParametersNull() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(1.05, null),
                Arguments.of(null, null)
        );
    }

    private static Stream<Arguments> provideParametersMax() {
        return Stream.of(
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 1.0)
        );
    }
}
