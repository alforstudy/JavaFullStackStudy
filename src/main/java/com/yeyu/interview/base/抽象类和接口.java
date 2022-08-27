package com.yeyu.interview.base;

abstract class PersonAbstract {
    String name;
    PersonAbstract(String name) {
        this.name = name;
    }
}


interface Person {
    String name = "";
//    Person(String name) {
//        this.name = name;
//    }
}

public class 抽象类和接口 {
    public static void main(String[] args) {
        System.out.println(Person.name);
//        System.out.println(PersonAbstract);
    }
}
