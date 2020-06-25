package com.yey.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class a13线程创建Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable接口实现类对象
        NumThread numThread = new NumThread();
        // 将此Callable接口实现类对象作为参数传递到FutureTask构造器中,创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        // 将FutureTask对象作为参数传递到Thread类的构造器中,创建Thread对象,然后开启线程运行
        new Thread(futureTask).start();
        // 这里是获取线程执行完成之后的返回值.
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

/**
 * call方法有返回值,支持泛型
 * call方法可以抛出异常
 */
// 创建一个Callable实现类
class NumThread implements Callable<Integer> {
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
