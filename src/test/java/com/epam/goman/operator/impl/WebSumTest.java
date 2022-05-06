package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WebSumTest {

    private final WebSum webSumOperate = new WebSum();

    @ParameterizedTest
    @CsvSource({"1, 1, 2.0", "1.00, 1.05, 2.05"})
    @DisplayName("Positive WebSum check")
    void operatePositive(Double x, Double y, Double result) {
        Number operate = webSumOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative WebSum null check")
    void operateNegativeNull(Number x, Number y) {
        assertThrows(NullPointerException.class, () -> {
            Number operate = webSumOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Check WebSum with max values")
    void operatePositiveMax(Number x, Number y, Number result) {
        Number operate = webSumOperate.operate(x, y);
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
                Arguments.of(1.05, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of(Integer.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY)
        );
    }

}
