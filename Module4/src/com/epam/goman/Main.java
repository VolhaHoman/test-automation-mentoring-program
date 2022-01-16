package com.epam.goman;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Calculator calc = new Calculator();
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
    }

    private static void firstTest(Calculator calculator) {
        Formula formula = new Formula(1, 2, "+");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void secondTest(Calculator calculator) {
        Formula formula = new Formula(10, 2, "-");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void thirdTest(Calculator calculator) {
        Formula formula = new Formula(9, .78652, "*");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void fourthTest(Calculator calculator) {
        Formula formula = new Formula(10, 2.8, "/");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void fifthTest(Calculator calculator) {
        Formula formula = new Formula(7, 2, "%");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void sixthTest(Calculator calculator) {
        Formula formula = new Formula(10, 0, "/");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void seventhTest(Calculator calculator) {
        Formula formula = new Formula(null, 0, "+");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void eighthTest(Calculator calculator) {
        Formula formula = new Formula(-1, 0, "+");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }

    private static void ninthTest(Calculator calculator) {
        Formula formula = new Formula(-1, -5, "*");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }
    private static void tenthTest(Calculator calculator) {
        Formula formula = new Formula(-15, -5, "-");
        double calculate = calculator.calculate(formula);
        System.out.println(calculate);
    }
}
