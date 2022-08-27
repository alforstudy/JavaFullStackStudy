package com.yeyu.base;

public class ThChapter {
    public static void main(String[] args) {
        new ThChapter().t6();
    }

    public void t1(){
        String s = null;
        String s1 = "abc";
        String s2 = new String("asd");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }

    public void t2() {
        //  Java 的基本类型 存储在栈内存中
        // 所以对于这些基本类型的创建方法，Java 使用了和 C/C++ 一样的策略。也就是说，不是使用 new 创建变量，而是使用一个“自动”变量。 这个变量直接存储"值"，并置于栈内存中
        char c = 'x';
        Character ch = new Character(c);
        // 基本类型自动转换成包装类型（自动装箱）
        Character ch1 = 'x';
        // 包装类型转化为基本类型（自动拆箱)
        char c1 = ch1;
        // BigInteger 、 BigDecimal
    }

    public void t3() {
        // 变量作用域
        int x = 13;
        {
            // 和C/CPP不太一样，不可以隐藏外部的x
            // int x = 15;
        }
        // 对象作用域
        // Java 对象与基本类型具有不同的生命周期。当我们使用 new 关键字来创建 Java 对象时，它的生命周期将会超出作用域
    }

    public void t4() {
        ATypeName a = new ATypeName();
        DataOnly data = new DataOnly();
        System.out.println(data);
    }


    public void t5() {
        /**
         *  [返回类型] [方法名](参数列表){
         *      // 方法体
         * }
         */

        //方法的返回类型表明了当你调用它时会返回的结果类型。
        // 参数列表则显示了可被传递到方法内部的参数类型及名称。
        // 方法名和参数列表统称为方法签名（signature of the method）。签名作为方法的唯一标识。
        // Java 中的方法只能作为类的一部分创建。它只能被对象所调用 ^4，并且该对象必须有权限来执行调用。若对象调用错误的方法，则程序将在编译时报错。
        // [对象引用].[方法名](参数1, 参数2, 参数3);
    }

    public void t6() {
        // 有时你只想为特定字段（注：也称为属性、域）分配一个共享存储空间，而不去考虑究竟要创建多少对象，甚至根本就不创建对象。
        // 创建一个与此类的任何对象无关的方法。也就是说，即使没有创建对象，也能调用该方法。
        StaticTest staticTest = new StaticTest();
        StaticTest staticTest1 = new StaticTest();
        staticTest.i++;
        System.out.println(staticTest.i);
    }

}

class StaticTest {
    static int i = 47;
    static void increment() {
        StaticTest.i++;
    }
}

class ATypeName {
    // 这里是类的内部
}


// 如果类的成员变量（字段）是基本类型，那么在类初始化时，这些类型将会被赋予一个初始值。
// 这种默认值的赋予并不适用于局部变量 —— 那些不属于类的字段的变量
class DataOnly {
    boolean b;
    char c;
    byte by;
    short s;
    int i;
    long l;
    double d;
    float f;

    @Override
    public String toString() {
        return "DataOnly{" +
                "b=" + b +
                ", c=" + c +
                ", by=" + by +
                ", s=" + s +
                ", i=" + i +
                ", l=" + l +
                ", d=" + d +
                ", f=" + f +
                '}';
    }
}

