package com.yey.thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class a11Lock锁方式解决线程安全问题 {
    /**
     * ReentrantLock 与 synchronized都是解决线程安全的问题,
     * 他们的区别是
     * synchronized在执行相应的同步代码后自动释放同步锁
     * Lock需要手动启动同步也需要手动结束同步
     */
    class Window implements Runnable {
        private int ticket = 100;
        // JDK 1.5
        // new ReentrantLock(true): 公平锁,线程先进先出.0号,1号,2号,0号,1号,2号 这样子.
        private ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            while (true) {
                try {
                    reentrantLock.lock();
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    @Test
    public void Runnable方式实现卖票() {
        // ticket 不用声明成静态的就能共享内存了,因为Window是单一的.
        Window window = new Window();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}
