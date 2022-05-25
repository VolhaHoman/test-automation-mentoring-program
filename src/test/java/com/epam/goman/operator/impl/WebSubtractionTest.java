package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WebSubtractionTest {

    private final WebSubtraction webSubtractionOperate = new WebSubtraction();

    @ParameterizedTest
    @CsvSource({"5, 3, 2.0", "2.00, 1.05, 0.95"})
    @DisplayName("Positive WebSubtraction check")
    void operatePositive(Double x, Double y, Double result) {
        Number operate = webSubtractionOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative WebSubtraction null check")
    void operateNegativeNull(Number x, Number y) {
        assertThrows(NullPointerException.class, () -> {
            Number operate = webSubtractionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Check WebSubtraction with max values")
    void operatePositiveMax(Number x, Number y, Double result) {
        Number operate = webSubtractionOperate.operate(x, y);
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
                Arguments.of(Double.MAX_VALUE, 1, Double.POSITIVE_INFINITY),
                Arguments.of(-1.05, Double.MAX_VALUE, 0.0),
                Arguments.of(Integer.MAX_VALUE, Double.MAX_VALUE, 0.0)
        );
    }
}
