package com.epam.goman.model;

import com.epam.goman.model.exception.ParameterIsNullException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormulaTest {

    private static final int X = 1;
    private static final int Y = 4;
    private static final String SUM_OPERATOR = "+";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String SUBTRACTION_OPERATOR = "-";
    private static final Formula validFormula = new Formula(X, Y, SUM_OPERATOR);
    private static final String DIVISION_OPERATOR = "/";
    private static final String BLANK_OPERATOR = "";
    private static final String FORMULA_STRING_VALUE = "Formula{x=1, y=4, operator='+'}";

    @Test
    @DisplayName("Check if the operator is blank")
    void constructorOperatorIsBlank() {
        assertThrows(ParameterIsNullException.class, () -> {
            Formula formula = new Formula(X, Y, BLANK_OPERATOR);
        });
    }

    @Test
    @DisplayName("Check if the operator is null")
    void constructorOperatorIsNull() {
        assertThrows(NullPointerException.class, () -> new Formula(X, Y, null));
    }

    @Test
    @DisplayName("Check if number X is null")
    void constructorNumberXIsNull() {
        assertThrows(NullPointerException.class, () -> {
            Formula formula = new Formula(null, Y, SUM_OPERATOR);
        });
    }

    @Test
    @DisplayName("Check if number Y is null")
    void constructorNumberYIsNull() {
        assertThrows(NullPointerException.class, () -> {
            Formula formula = new Formula(X, null, SUM_OPERATOR);
        });
    }

    @Test
    @DisplayName("Check number X exists")
    void getX() {
        assertEquals(X, validFormula.getX());
    }

    @Test
    @DisplayName("Check number Y exists")
    void getY() {
        assertEquals(Y, validFormula.getY());
    }


    @Test
    @DisplayName("Check operator exists")
    void getOperator() {
        assertEquals(SUM_OPERATOR, validFormula.getOperator());
    }

    @Test
    @DisplayName("Check sum operator")
    void setOperatorSum() {
        Formula formula = new Formula(X, Y, SUM_OPERATOR);
        formula.setOperator(DIVISION_OPERATOR);
        assertEquals(DIVISION_OPERATOR, formula.getOperator());
    }

    @Test
    @DisplayName("Check division operator")
    void setOperatorDivision() {
        Formula formula = new Formula(X, Y, DIVISION_OPERATOR);
        formula.setOperator(DIVISION_OPERATOR);
        assertEquals(DIVISION_OPERATOR, formula.getOperator());
    }

    @Test
    @DisplayName("Check multiply operator")
    void setOperatorMultiply() {
        Formula formula = new Formula(X, Y, MULTIPLY_OPERATOR);
        formula.setOperator(MULTIPLY_OPERATOR);
        assertEquals(MULTIPLY_OPERATOR, formula.getOperator());
    }

    @Test
    @DisplayName("Check subtraction operator")
    void setOperatorSubtraction() {
        Formula formula = new Formula(X, Y, SUBTRACTION_OPERATOR);
        formula.setOperator(SUBTRACTION_OPERATOR);
        assertEquals(SUBTRACTION_OPERATOR, formula.getOperator());
    }

    @Test
    @DisplayName("Check toString for formula")
    void testToString() {
        Formula formula = new Formula(X, Y, SUM_OPERATOR);
        assertEquals(FORMULA_STRING_VALUE, formula.toString());
    }

    @Test
    @DisplayName("Check testEquals")
    void testEquals() {
        Formula formula = new Formula(X, Y, SUM_OPERATOR);
        Formula copiedFormula = new Formula(X, Y, SUM_OPERATOR);
        assertEquals(formula, copiedFormula);
    }

    @Test
    @DisplayName("Check testHashCode")
    void testHashCode() {
        Formula formula = new Formula(X, Y, SUM_OPERATOR);
        Formula copiedFormula = new Formula(X, Y, SUM_OPERATOR);
        assertEquals(formula.hashCode(), copiedFormula.hashCode());
    }
}
