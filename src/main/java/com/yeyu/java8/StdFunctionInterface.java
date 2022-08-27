package com.yeyu.java8;

import java.util.function.Predicate;

public class StdFunctionInterface {
    public static void main(String[] args) {
        t1();
    }

    static void t1() {
        //
        Predicate<String> predicate = (str) -> str.length() > 0;
        Predicate<String> predicate2 = (str) -> str.length() < 10;
        Predicate<String> stringPredicate = predicate.and(predicate2);
        System.out.println(stringPredicate.test("123"));


    }

    static void t2() {

    }
}
