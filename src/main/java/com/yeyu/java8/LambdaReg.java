package com.yeyu.java8;

import java.util.*;

public class LambdaReg {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(strings, (o1, o2) -> o1.compareTo(o2));
        Collections.sort(strings, String::compareTo);
    }
}
