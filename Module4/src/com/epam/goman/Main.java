package com.epam.goman;

import com.epam.goman.model.Calculator;
import com.epam.goman.model.Formula;
import com.epam.goman.model.LocalCalculator;
import com.epam.goman.validator.FormulaValidator;

public class Main {

    public static void main(String[] args) {

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
    }

    private static void baseTest(Formula formula){
        try{
            Calculator calc = new LocalCalculator();
            Number calculate = calc.calculate(formula, new FormulaValidator());
            System.out.println(calculate);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void firstTest() {
        Formula formula = new Formula(1, 2, "+");
        baseTest(formula);
    }

    private static void secondTest() {
        Formula formula = new Formula(10, 2, "-");
        baseTest(formula);
    }

    private static void thirdTest() {
        Formula formula = new Formula(9, .78652, "*");
        baseTest(formula);
    }

    private static void fourthTest() {
        Formula formula = new Formula(10, 2.8, "/");
        baseTest(formula);
    }

    private static void fifthTest() {
        Formula formula = new Formula(7, 2, "%");
        baseTest(formula);
    }

    private static void sixthTest() {
        Formula formula = new Formula(10, 0, "/");
        baseTest(formula);
    }

    private static void seventhTest() {
        Formula formula = new Formula(null, 0, "+");
        baseTest(formula);
    }

    private static void eighthTest() {
        Formula formula = new Formula(-1, 0, "+");
        baseTest(formula);
    }

    private static void ninthTest() {
        Formula formula = new Formula(-1, -5, "*");
        baseTest(formula);
    }
    private static void tenthTest() {
        Formula formula = new Formula(-15, -5, "-");
        baseTest(formula);
    }
}
