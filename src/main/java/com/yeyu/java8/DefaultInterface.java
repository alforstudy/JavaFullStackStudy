package com.yeyu.java8;


interface Formula {
    double calc(double a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

public class DefaultInterface implements Formula {
    @Override
    public double calc(double a) {
        return 0;
    }

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calc(double a) {
                return 0;
            }
        };
        System.out.println(formula.calc(0));
        System.out.println(formula.sqrt(10));

    }
}
