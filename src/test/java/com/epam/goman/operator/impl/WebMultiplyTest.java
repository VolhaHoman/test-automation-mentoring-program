package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WebMultiplyTest {

    private final WebMultiply webMultiplyOperate = new WebMultiply();

    @ParameterizedTest
    @CsvSource({"2, 2, 4", "1.00, 1.05, 1.05"})
    @DisplayName("Positive WebMultiply check")
    void operatePositive(Double x, Double y, Double result) {
        Number operate = webMultiplyOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative WebMultiply null check")
    void operateNegativeNull(Number x, Number y) {
        assertThrows(NullPointerException.class, () -> {
            Number operate = webMultiplyOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Check WebMultiply with max values")
    void operatePositiveMax(Number x, Number y, Number result) {
        Number operate = webMultiplyOperate.operate(x, y);
        assertEquals(result, (Number) operate);
    }

    private static Stream<Arguments> provideParametersNull() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(1.05, null)
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
