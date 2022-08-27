package com.yeyu.interview.base;

public class 反射 {
    public static void main(String[] args) {
        String[] strings = {"1", "2"};
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getName());
        System.out.println(strings.getClass().getCanonicalName());
    }
}
