package com.yeyu.base.继承;


/**
 * 著作权归https://pdai.tech所有。
 * 链接：https://pdai.tech/md/java/basic/java-basic-lan-basic.html
 *
 * 从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所有父类对象。
 * 而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具有 IS-A 关系。
 * 从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类。
 * 接口的字段只能是 static 和 final 类型的，而抽象类的字段没有这种限制。
 * 接口的成员只能是 public 的，而抽象类的成员可以有多种访问权限。
 */

interface InterfaceExample {
    void func1();

    default void func2(){
        System.out.println("func2");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    public int z = 0;       // Modifier 'public' is redundant for interface fields
//     private int k = 0;   // Modifier 'private' not allowed here
//     protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}


class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
}


public class 接口 {
    public static void main(String[] args) {
        InterfaceImplementExample interfaceImplementExample = new InterfaceImplementExample();
        System.out.println(new InterfaceImplementExample().x);
    }
}
