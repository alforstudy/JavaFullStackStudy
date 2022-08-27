package com.yeyu.interview.base;

public class 线程 {
    public static void main(String[] args) throws InterruptedException {
        Thread test = new Thread(() -> {
            while (true) {
                System.out.println("test");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        test.setDaemon(true);
        test.start();
//        test.join();
    }
}
