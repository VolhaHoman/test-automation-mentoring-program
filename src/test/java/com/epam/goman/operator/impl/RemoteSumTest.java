package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoteSumTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "1.00, 1.05, 2.05"})
    @DisplayName("Positive RemoteSum check")
    void operatePositive(Double x, Double y, Double result) {
        RemoteSum remoteSumOperate = new RemoteSum();
        Number operate = remoteSumOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative RemoteSum null check")
    void operateNegativeNull(Number x, Number y) {
        RemoteSum remoteSumOperate = new RemoteSum();
        assertThrows(NullPointerException.class, () -> {
            Number operate = remoteSumOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Check RemoteSum with max values")
    void operatePositiveMax(Number x, Number y, Number result) {
        RemoteSum remoteSumOperate = new RemoteSum();
        Number operate = remoteSumOperate.operate(x, y);
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
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE + 1),
                Arguments.of(1.05, Double.MAX_VALUE, Double.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)
        );
    }

}
