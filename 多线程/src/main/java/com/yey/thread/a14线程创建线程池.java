package com.yey.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 提前创建好多个线程,放入线程池中,使用时直接获取,使用完放回池中,可以避免频繁的创建销毁,实现重复利用.
 */

/**
 * Executors: 工具类,线程池的工厂类,用于创建并返回不同类型的线程池.
 */
public class a14线程创建线程池 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Executors.newCachedThreadPool(): 创建一个可根据需要创建新线程的线程池
//        Executors.newFixedThreadPool(): 创建一个可重用固定线程数的线程池.
//        Executors.newSingleThreadExecutor(): 创建一个只有一个线程的线程池
//        Executors.newScheduledThreadPool(): 创建一个线程池,,它可安排给定延迟后运行命令或者定期执行

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        // 设置线程池的属性



        // executorService.execute(new Runnable1());// 适合适用于Runnable
        // executorService.execute(new Runnable2());// 适合适用于Runnable
        Future<Integer> submit = executorService.submit(new NumThread1());// 适合适用于Callable
        System.out.println(submit.get());// Callable有返回值的
        executorService.shutdown();// 关闭连接池
    }

}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}

class Runnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}

class NumThread1 implements Callable<Integer> {
    // 实现Call方法,将此线程需要执行的操作声明在call方法中,同时这个call()方法可以有一个返回值.
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
