package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "2.00, 1.05, 0.95"})
    @DisplayName("Positive Subtraction check")
    void operatePositive(Double x, Double y, Double result) {
        Subtraction subtractionOperate = new Subtraction();
        Number operate = subtractionOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative Subtraction null check")
    void operateNegativeNull(Number x, Number y) {
        Subtraction subtractionOperate = new Subtraction();
        assertThrows(NullPointerException.class, () -> {
            Number operate = subtractionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Negative Subtraction max check")
    void operateNegativeMax(Number x, Number y, Number result) {
        Subtraction subtractionOperate = new Subtraction();
        Number operate = subtractionOperate.operate(x, y);
        assertEquals(result, operate);
    }

    @Test
    @DisplayName("Check correct value of Subtraction get operator value")
    void getOperatorValue() {
        Subtraction subtraction = new Subtraction();
        assertEquals("-", subtraction.getOperatorValue());
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
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE-1),
                Arguments.of(-1.05, Double.MAX_VALUE, -1.05-Double.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Double.MAX_VALUE, Integer.MAX_VALUE-Double.MAX_VALUE)
        );
    }
}
