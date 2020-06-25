package com.yey.thread;

import org.junit.Test;

public class a08同步方法 {
    /**
     * 操作共享数据的代码,即为需要被同步的代码.
     * 共享数据:多个线程共同操作的变量.
     * 同步监视器: 俗称,锁,任何一个对象都可以称为锁.
     */
    class Window implements Runnable {
        private int ticket = 100;

        @Override
        public void run() {
            while (true) {
                show();
            }
        }

        // 同步方法中的锁就是this
        private synchronized void show() {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                    ticket--;
                } else {
                    return;
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
