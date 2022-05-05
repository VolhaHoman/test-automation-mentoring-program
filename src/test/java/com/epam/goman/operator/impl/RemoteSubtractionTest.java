package com.epam.goman.operator.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoteSubtractionTest {

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "2.00, 1.05, 0.95"})
    @DisplayName("Positive RemoteSubtraction check")
    void operatePositive(Double x, Double y, Double result) {
        RemoteSubtraction remoteSubtractionOperate = new RemoteSubtraction();
        Number operate = remoteSubtractionOperate.operate((Number) x, (Number) y);
        assertEquals(result, (Number) operate);
    }

    @ParameterizedTest
    @MethodSource("provideParametersNull")
    @DisplayName("Negative RemoteSubtraction null check")
    void operateNegativeNull(Number x, Number y) {
        RemoteSubtraction remoteSubtractionOperate = new RemoteSubtraction();
        assertThrows(NullPointerException.class, () -> {
            Number operate = remoteSubtractionOperate.operate(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("provideParametersMax")
    @DisplayName("Check RemoteSubtraction with max values")
    void operatePositiveMax(Number x, Number y, Number result) {
        RemoteSubtraction remoteSubtractionOperate = new RemoteSubtraction();
        Number operate = remoteSubtractionOperate.operate(x, y);
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
                Arguments.of(Double.MAX_VALUE, 1, Double.MAX_VALUE),
                Arguments.of(-1.05, Double.MAX_VALUE, -1.05-Double.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Double.MIN_VALUE, Integer.MAX_VALUE-Double.MIN_VALUE)
        );
    }
}
