package com.yeyu.java8;

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

public class MethodCall {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        System.out.println(converter.convert("123"));

        Something something = new Something();
        Converter<String, String> converter1 = something::startsWith;

        PersonFactory<Person> pf = Person::new;
        Person person = pf.create("a", "b");
        System.out.println(person);

    }
}
