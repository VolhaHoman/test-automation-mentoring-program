package com.epam.goman.model;

public class FormulaDto {

    public FormulaDto(String operator, Number x, Number y, Number result) {
        this.operator = operator;
        this.x = x;
        this.y = y;
        this.result = result;
    }

    private String operator;
    private Number x;
    private Number y;
    private Number result;

    @Override
    public String toString() {
        return x + operator + y + "=" + result;
    }
}
