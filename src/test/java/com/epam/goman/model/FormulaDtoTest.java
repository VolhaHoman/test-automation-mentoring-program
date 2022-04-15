package com.epam.goman.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FormulaDtoTest {

    @ParameterizedTest
    @MethodSource("getFormulae")
    @DisplayName("Check toString")
    void testToString(FormulaDto formula, String result) {
        assertEquals(formula.toString(), result);
    }

    private static Stream<Arguments> getFormulae() {
        return Stream.of(
                Arguments.of(new FormulaDto("+", 1, 4, 5), "1+4=5"),
                Arguments.of(new FormulaDto("+", -1, 4, 3), "-1+4=3"),
                Arguments.of(new FormulaDto("+", 9, 4, 13), "9+4=13")
        );
    }
}
