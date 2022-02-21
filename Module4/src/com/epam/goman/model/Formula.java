package com.epam.goman.model;

import java.util.Objects;

public class Formula {

    private Number x;

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

    private Number y;
    private String operator;

    public Formula(Number x, Number y, String operator) {
        this.x = x;
        this.y = y;
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
}
