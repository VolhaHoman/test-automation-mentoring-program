package com.epam.goman;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.impl.Division;
import com.epam.goman.operator.impl.Multiply;
import com.epam.goman.operator.impl.Subtraction;
import com.epam.goman.operator.impl.Sum;
import com.epam.goman.service.Calculator;
import com.epam.goman.service.impl.LocalCalculator;
import com.epam.goman.service.impl.ProxyCalculator;

public class Main {

    public static void main(String[] args) {

        ProxyCalculator calc = new ProxyCalculator(new LocalCalculator());
        try {
            calc.addOperator(new Division());
            calc.addOperator(new Multiply());
            calc.addOperator(new Subtraction());
            calc.addOperator(new Sum());
            calc.addOperator(null);
        } catch (ParameterIsNullException e) {
            System.out.println(e.getLocalizedMessage());
        }
        firstTest(calc);
        firstTest(calc);
        secondTest(calc);
        thirdTest(calc);
        fourthTest(calc);
        fifthTest(calc);
        sixthTest(calc);
        eighthTest(calc);
        ninthTest(calc);
        tenthTest(calc);
        seventhTest(calc);
        try {
            System.out.println(calc.getLast(2));
            System.out.println(calc.getLast(100));
        } catch (InvalidOperatorException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    private static void baseTest(Formula formula, Calculator calc) {
        try {
            Number calculate = calc.calculate(formula);
            System.out.println(calculate);
        } catch (ParameterIsNullException e) {
            System.out.println("ParameterIsNullException: " + e.getLocalizedMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private static void firstTest(Calculator calc) {
        Formula formula = new Formula(1, 2, "+");
        baseTest(formula, calc);
    }

    private static void secondTest(Calculator calc) {
        Formula formula = new Formula(10, 2, "-");
        baseTest(formula, calc);
    }

    private static void thirdTest(Calculator calc) {
        Formula formula = new Formula(9, .78652, "*");
        baseTest(formula, calc);
    }

    private static void fourthTest(Calculator calc) {
        Formula formula = new Formula(10, 2.8, "/");
        baseTest(formula, calc);
    }

    private static void fifthTest(Calculator calc) {
        Formula formula = new Formula(7, 2, "%");
        baseTest(formula, calc);
    }

    private static void sixthTest(Calculator calc) {
        Formula formula = new Formula(10, 0, "/");
        baseTest(formula, calc);
    }

    private static void seventhTest(Calculator calc) {
        Formula formula = new Formula(null, 0, "+");
        baseTest(formula, calc);
    }

    private static void eighthTest(Calculator calc) {
        Formula formula = new Formula(-1, 0, "+");
        baseTest(formula, calc);
    }

    private static void ninthTest(Calculator calc) {
        Formula formula = new Formula(-1, -5, "*");
        baseTest(formula, calc);
    }

    private static void tenthTest(Calculator calc) {
        Formula formula = new Formula(-15, -5, "-");
        baseTest(formula, calc);
    }
}
