package ru.job4j.oop;

public class Calculator {
    private static  int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return Calculator.sum(a) + multiply(a) + Calculator.minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        int result1 = minus(10);
        int rsl1 = calculator.divide(10);
        System.out.println(result);
        System.out.println(rsl);
        System.out.println(result1);
        System.out.println(rsl1);
        System.out.println(calculator.sumAllOperation(10));
    }
}
