package com.epam.goman;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.OperatorNotFoundException;
import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.operator.impl.Division;
import com.epam.goman.operator.impl.Multiply;
import com.epam.goman.operator.impl.Subtraction;
import com.epam.goman.operator.impl.Sum;
import com.epam.goman.service.impl.LocalCalculator;
import com.epam.goman.service.impl.ProxyCalculator;

public class Main {

    private static final ProxyCalculator calc = new ProxyCalculator(new LocalCalculator());

    public static void main(String[] args) {

        // Operators collection is empty
        tryCalcWithEmptyOperators();

        try {
            calc.addOperator(new Division());
            calc.addOperator(new Multiply());
            calc.addOperator(new Subtraction());
            calc.addOperator(new Sum());
            calc.addOperator(null);
        } catch (ParameterIsNullException e) {
            System.out.println(e.getLocalizedMessage());
        }

            firstTest();
            firstTest();
            secondTest();
            thirdTest();
            fourthTest();
            fifthTest();
            sixthTest();
            eighthTest();
            ninthTest();
            tenthTest();
            seventhTest();
            eleventhTest();

        try {
            System.out.println(calc.getLast(2));
            System.out.println(calc.getLast(100));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound exception: " + e.getLocalizedMessage());
        }

    }

    private static void tryCalcWithEmptyOperators() {
        ProxyCalculator calcWithEmptyOperators = new ProxyCalculator(new LocalCalculator());
        try {
            calcWithEmptyOperators.calculate(new Formula(45, 32, "-"));
        } catch (OperatorNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void baseTest(Number x, Number y, String operator) {
        try {
            Number calculate = calc.calculate(new Formula(x, y, operator));
            System.out.println(calculate);
        } catch (ParameterIsNullException e) {
            System.out.println("ParameterIsNullException: " + e.getLocalizedMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private static void firstTest() {
        baseTest(1, 2, "+");
    }

    private static void secondTest() {
        baseTest(10, 2, "-");
    }

    private static void thirdTest() {
        baseTest(9, .78652, "*");
    }

    private static void fourthTest() {
        baseTest(10, 2.8, "/");
    }

    private static void fifthTest() {
        baseTest(7, 2, "%");
    }

    private static void sixthTest() {
        baseTest(10, 0, "/");
    }

    private static void seventhTest() {
        baseTest(null, 0, "+");
    }

    private static void eighthTest() {
        baseTest(-1, 0, "+");
    }

    private static void ninthTest() {
        baseTest(-1, -5, "*");
    }

    private static void tenthTest() {
        baseTest(-15, -5, "-");
    }

    private static void eleventhTest() {
        baseTest(655, -5, null);
    }
}
