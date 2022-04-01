package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @ParameterizedTest
    @CsvSource({"2, 2, 4", "1.00, 1.05, 1.05"})
    @DisplayName("Positive Multiply check")
    void operatePositive(Double x, Double y, Double result) {
        Multiply multiplyOperate = new Multiply();
        Number operate = multiplyOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative Multiply null check")
    void operateNegativeNull(Number x, Number y) {
        Multiply multiplyOperate = new Multiply();
        assertThrows(NullPointerException.class, () -> {
            Number operate = multiplyOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Negative Multiply max check")
    void operateNegativeMax(Number x, Number y, Number result) {
        Multiply multiplyOperate = new Multiply();
        Number operate = multiplyOperate.operate(x, y);
        assertEquals(result, operate);
    }

    @Test
    @DisplayName("Check correct value of Multiply get operator value")
    void getOperatorValue() {
        Multiply multiply = new Multiply();
        assertEquals("*", multiply.getOperatorValue());
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
                Arguments.of(Integer.MAX_VALUE, 0, 0.0),
                Arguments.of(1.05, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of(-Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY)
        );
    }
}
