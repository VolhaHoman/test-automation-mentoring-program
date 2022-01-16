package com.epam.goman;

public class Calculator {

    public double multiply(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        if (y == 0) {
            System.out.println("Division by 0 is not allowed. The answer is 0");
            return 0;
        }
        return x / y;
    }

    public double sum(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double calculate(Formula formula) {
        String operator = formula.operator;

        double x = formula.x.doubleValue();
        double y = formula.y.doubleValue();

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
        System.out.println("Operator is not supported. The answer is 0");
        return 0;
    }
}
