package com.yeyu.juc;

public class TestDemo1 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class Data {
    int number = 0;

    public synchronized void increment() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"INC");
        if(number!=0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"->"+number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"DEC");
        if(number==0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"->"+number);
        this.notifyAll();
    }
}
