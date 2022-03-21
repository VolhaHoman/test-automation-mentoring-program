package com.epam.goman.model;

import com.epam.goman.model.exception.ParameterIsNullException;

import java.util.Objects;

public class Formula {

    private Number x;
    private Number y;
    private String operator;

    public Formula(Number x, Number y, String operator) {

        if (Objects.requireNonNull(operator, "Formula exception - Operator can't be null").isBlank()) {
            throw new ParameterIsNullException("Formula exception - Operator can't be empty");
        }

        this.x = Objects.requireNonNull(x, "Formula exception - Parameter x can't be null");
        this.y = Objects.requireNonNull(y, "Formula exception - Parameter y can't be null");
        this.operator = operator;
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "x=" + x +
                ", y=" + y +
                ", operator='" + operator + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return Objects.equals(x, formula.x) && Objects.equals(y, formula.y) && Objects.equals(operator, formula.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, operator);
    }
}
