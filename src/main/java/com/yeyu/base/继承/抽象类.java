package com.yeyu.base.继承;

abstract class AbstractClassExample {

    protected int x;
    private int y;

    public abstract void func1();

    public void func2() {
        System.out.println("AbstractClassExample func2");
    }
}

class AbstractExtendClassExample extends AbstractClassExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }

    @Override
    public void func2() {
        System.out.println("AbstractExtendClassExample func2");
    }
}



public class 抽象类 {
    public static void main(String[] args) {
        AbstractExtendClassExample abstractExtendClassExample = new AbstractExtendClassExample();
        abstractExtendClassExample.func1();
        abstractExtendClassExample.func2();
        System.out.println(abstractExtendClassExample.x);
    }
}
