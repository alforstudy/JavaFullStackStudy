package 并发;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class 锁 {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                /**
                 * ① 调用unpark函数，释放该线程的许可。
                 * ② 该线程被中断。
                 * ③ 设置的时间到了。并且，当time为绝对时间时，isAbsolute为true，
                 *    否则，isAbsolute为false。当time为0时，表示无限等待，直到unpark发生
                 */

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }

    @Test
    public void testLockSupport() throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();
        // unpark函数，释放线程的许可，即激活调用park后阻塞的线程。这个函数不是安全的，调用这个函数时要确保线程依旧存活
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }


    @Test
    public void testWait() throws InterruptedException {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("等待中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //                lock.notify();
            }
        });
        synchronized (lock) {
            t.start();
            lock.wait();
            System.out.println("等待中");
        }
    }

    class MyThread1 extends Thread {
        private Object object;

        public MyThread1(Object object) {
            this.object = object;
        }

        public void run() {
            System.out.println("before unpark");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取blocker
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
            // 释放许可
            LockSupport.unpark((Thread) object);
            // 休眠500ms，保证先执行park中的setBlocker(t, null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 再次获取blocker
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

            System.out.println("after unpark");
        }
    }

    @Test
    public void testPark() throws InterruptedException {
        MyThread1 myThread = new MyThread1(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
        Thread.sleep(1000);
    }

}
