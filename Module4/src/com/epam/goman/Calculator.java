package com.epam.goman;

public class Calculator {

    public double multiply(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) throws Exception {
        if (y == 0) {
            throw new Exception("Result exception: Division by 0 is not allowed");
        }
        return x / y;
    }

    public double sum(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double calculate(Formula formula) throws Exception {
        String operator = formula.getOperator();

        double x = formula.getX().doubleValue();
        double y = formula.getY().doubleValue();

        if ("*".equals(operator)) {
            return multiply(x, y);
        }
        if ("/".equals(operator)) {
            return division(x, y);
        }
        if ("+".equals(operator)) {
            return sum(x, y);
        }
        if ("-".equals(operator)) {
            return subtraction(x, y);
        }
        throw new Exception("Result exception: Invalid operator");
    }
}
