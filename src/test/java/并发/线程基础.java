package 并发;

import org.junit.Test;

import java.util.concurrent.*;

public class 线程基础 {

    class ThreadBase extends Thread {
        @Override
        public void run() {
            System.out.println("线程执行-Thread");
        }
    }

    class ThreadBase1 implements Runnable {
        @Override
        public void run() {
            System.out.println("线程执行-Runnable");
        }
    }

    @Test
    public void 实现线程() throws ExecutionException, InterruptedException {
        // 实现线程的几种方式
        // 1. 继承Thread
        Thread thread = new ThreadBase();
        thread.start();
        // 2. 实现Runnable
        new Thread(new ThreadBase1()).start();
        new Thread(() -> {
            System.out.println("线程执行-Runnable");
        }).start();
        // 3. 实现Callable
        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            return "线程执行-Callable";
        });
        new Thread(stringFutureTask, "CallableTest").start();
        String s = stringFutureTask.get();
        System.out.println(s);
    }


    class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("task 执行");
            Thread.sleep(1000 * 5);
            return 110;
        }
    }

    @Test
    public void FutureTaskTest() throws ExecutionException, InterruptedException {
        Task task = new Task();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(task);
        Integer integer = submit.get();
        System.out.println(integer);
        FutureTask<Integer> task1 = new FutureTask<>(task);
        executorService.submit(task1);
        System.out.println(task1.get());
    }


    @Test
    public void ExecutorTest() {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(100);
        Executors.newSingleThreadExecutor();
    }


    @Test
    public void scheduleThreadPool() {
        Executors.newScheduledThreadPool(1);
    }
}




