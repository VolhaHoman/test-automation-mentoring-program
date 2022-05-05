package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoteDivisionTest {

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative RemoteDivision null check")
    void operateNegativeNull(Number x, Number y) {
        RemoteDivision remoteDivisionOperate = new RemoteDivision();
        assertThrows(NullPointerException.class, () -> {
            Number operate = remoteDivisionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource({"providePositiveParametersWithMax"})
    @DisplayName("Positive RemoteDivision and with max check")
    void operatePositiveAndMax(Number x, Number y, Number result) {
        RemoteDivision remoteDivisionOperate = new RemoteDivision();
        assertEquals(result, remoteDivisionOperate.operate(x,y));
    }

    @Test
    @DisplayName("Negative RemoteDivision by zero check")
    void operateNegativeZero() {
        RemoteDivision remoteDivisionOperate = new RemoteDivision();
        assertThrows(ArithmeticException.class, () -> {
            Number operate = remoteDivisionOperate.operate(5, 0);
        });
    }

    private static Stream<Arguments> provideParametersNull() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(1.05, null)
        );
    }

    private static Stream<Arguments> providePositiveParametersWithMax() {
        return Stream.of(
                Arguments.of(8, 2, 4.0),
                Arguments.of(4.20, 1.05, 4.0),
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 1.0)
        );
    }
}
