package com.yeyu.base;

public class SixthChapter {
    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testConstVal();
        p.testChar();
        p.testByte();
        p.testShort();
        p.testInt();
        p.testLong();
        p.testFloat();
        p.testDouble();
    }

}


class Rock {
    // 构造器名称与类名相同。在初始化过程中自动调用构造器方法是有意义的。
    // 一个无参构造器就是不接收参数的构造器，用来创建一个"默认的对象"。如果你创建一个类，类中没有构造器，那么编译器就会自动为你创建一个无参构造器。
    // 一旦你显式地定义了构造器（无论有参还是无参），编译器就不会自动为你创建无参构造器
    // 现在，当创建一个对象时：new Rock() ，内存被分配，构造器被调用。构造器保证了对象在你使用它之前进行了正确的初始化。
    // 构造器没有返回值，它是一种特殊的方法。但它和返回类型为 void 的普通方法不同，普通方法可以返回空值，你还能选择让它返回别的类型；而构造器没有返回值，却同时也没有给你选择的余地（new 表达式虽然返回了刚创建的对象的引用，但构造器本身却没有返回任何值）。如果它有返回值，并且你也可以自己选择让它返回什么，那么编译器就还得知道接下来该怎么处理那个返回值（这个返回值没有接收者）

    Rock() { // 这是一个构造器
        System.out.print("Rock ");
    }

    // 通常当你说 this，意味着"这个对象"或"当前对象"，它本身生成对当前对象的引用。在一个构造器中，当你给 this 一个参数列表时，它是另一层意思。它通过最直接的方式显式地调用匹配参数列表的构造器
    // 只能通过 this 调用一次构造器。另外，必须首先调用构造器，否则编译器会报错
    // 记住了 this 关键字的内容，你会对 static 修饰的方法有更加深入的理解：static 方法中不会存在 this。你不能在静态方法中调用非静态方法（反之可以）
    Rock(int i) {
        this();
        System.out.print("Rock " + i + " ");
    }
}


class PrimitiveOverloading {
    void f1(char x) {
        System.out.print("f1(char)");
    }

    void f1(byte x) {
        System.out.print("f1(byte)");
    }

    void f1(short x) {
        System.out.print("f1(short)");
    }

    void f1(int x) {
        System.out.print("f1(int)");
    }

    void f1(long x) {
        System.out.print("f1(long)");
    }

    void f1(float x) {
        System.out.print("f1(float)");
    }

    void f1(double x) {
        System.out.print("f1(double)");
    }

    void f2(byte x) {
        System.out.print("f2(byte)");
    }

    void f2(short x) {
        System.out.print("f2(short)");
    }

    void f2(int x) {
        System.out.print("f2(int)");
    }

    void f2(long x) {
        System.out.print("f2(long)");
    }

    void f2(float x) {
        System.out.print("f2(float)");
    }

    void f2(double x) {
        System.out.print("f2(double)");
    }

    void f3(short x) {
        System.out.print("f3(short)");
    }

    void f3(int x) {
        System.out.print("f3(int)");
    }

    void f3(long x) {
        System.out.print("f3(long)");
    }

    void f3(float x) {
        System.out.print("f3(float)");
    }

    void f3(double x) {
        System.out.print("f3(double)");
    }

    void f4(int x) {
        System.out.print("f4(int)");
    }

    void f4(long x) {
        System.out.print("f4(long)");
    }

    void f4(float x) {
        System.out.print("f4(float)");
    }

    void f4(double x) {
        System.out.print("f4(double)");
    }

    void f5(long x) {
        System.out.print("f5(long)");
    }

    void f5(float x) {
        System.out.print("f5(float)");
    }

    void f5(double x) {
        System.out.print("f5(double)");
    }

    void f6(float x) {
        System.out.print("f6(float)");
    }

    void f6(double x) {
        System.out.print("f6(double)");
    }

    void f7(double x) {
        System.out.print("f7(double)");
    }

    void testConstVal() {
        System.out.print("5: ");
        f1(5);
        f2(5);
        f3(5);
        f4(5);
        f5(5);
        f6(5);
        f7(5);
        System.out.println();
    }

    void testChar() {
        char x = 'x';
        System.out.print("char: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testByte() {
        byte x = 0;
        System.out.print("byte: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testShort() {
        short x = 0;
        System.out.print("short: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testInt() {
        int x = 0;
        System.out.print("int: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testLong() {
        long x = 0;
        System.out.print("long: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testFloat() {
        float x = 0;
        System.out.print("float: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    void testDouble() {
        double x = 0;
        System.out.print("double: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }
}