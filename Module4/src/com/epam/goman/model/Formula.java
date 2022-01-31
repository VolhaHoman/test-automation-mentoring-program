package com.epam.goman.model;

public class Formula {

    private Number x;
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
}
