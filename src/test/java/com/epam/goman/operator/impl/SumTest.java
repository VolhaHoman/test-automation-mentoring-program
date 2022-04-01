package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1.00, 1.05, 2.05"})
    @DisplayName("Positive Sum check")
    void operatePositive(Double x, Double y, Double result) {
        Sum sumOperate = new Sum();
        Number operate = sumOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative Sum null check")
    void operateNegativeNull(Number x, Number y) {
        Sum sumOperate = new Sum();
        assertThrows(NullPointerException.class, () -> {
            Number operate = sumOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Negative Sum max check")
    void operateNegativeMax(Number x, Number y, Number result) {
        Sum sumOperate = new Sum();
        Number operate = sumOperate.operate(x, y);
        assertEquals(result, operate);
    }

    @Test
    @DisplayName("Check correct value of Sum get operator value")
    void getOperatorValue() {
        Sum sum = new Sum();
        assertEquals("+", sum.getOperatorValue());
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
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE + 1),
                Arguments.of(1.05, Double.MAX_VALUE, Double.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)
        );
    }

}
