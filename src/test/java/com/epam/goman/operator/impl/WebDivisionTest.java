package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WebDivisionTest {

    private final WebDivision webDivisionOperate = new WebDivision();

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative WebDivision null check")
    void operateNegativeNull(Number x, Number y) {
        assertThrows(NullPointerException.class, () -> {
            Number operate = webDivisionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource({"providePositiveParametersWithMax"})
    @DisplayName("Positive WebDivision and with max check")
    void operatePositiveAndMax(Number x, Number y, Number result) {
        assertEquals(result, webDivisionOperate.operate(x,y));
    }

    @Test
    @DisplayName("Negative WebDivision by zero check")
    void operateNegativeZero() {
        assertThrows(ArithmeticException.class, () -> {
            Number operate = webDivisionOperate.operate(5, 0);
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
                Arguments.of(Double.MAX_VALUE, 1, Double.POSITIVE_INFINITY),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 1.0)
        );
    }
}
