package com.yeyu.java8;


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

public class FunctionInterfaceTest {
    // 静态变量
    static int outerStaticNum;
    // 成员变量
    int outerNum;

    public static void main(String[] args) {

        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        System.out.println(converter.convert("123"));

        // 与匿名内部类不同的是，我们不必显式声明 num 变量为 final 类型，下面这段代码同样有效
        int num = 1;
        Converter<Integer, String> converter2 = from -> {
            // num = 4;
            // 对成员变量赋值
            return String.valueOf(from + num);
        };
        System.out.println(converter2.convert(10));
        // 但是 num 变量必须为隐式的 final 类型，何为隐式的 final 呢？就是说到编译期为止，num 对象是不能被改变的，如下面这段代码，就不能被编译通过
        // num = 3;


        new FunctionInterfaceTest().test();

    }

    void test() {
        Converter<Integer, String> converter2 = from -> {
            outerNum = 10;
            outerStaticNum = 20;
            return String.valueOf(from + outerNum + outerStaticNum);
        };
        System.out.println(converter2.convert(10));
    }
}
