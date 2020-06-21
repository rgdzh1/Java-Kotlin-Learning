package com.yey.thread;

import org.junit.Test;

public class a04窗口卖票问题 {
    class Window implements Runnable {
        private int ticket = 100;

        @Override
        public void run() {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                    ticket--;
                } else {
                    break;
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

    static class Window1 extends Thread {
        // 为了让不同线程能共享ticket,还需要将ticket声明成静态的.
        private static int ticket = 100;

        @Override
        public void run() {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    @Test
    public void 继承的方式实现卖票() {
        new Window1().start();
        new Window1().start();
        new Window1().start();
    }
}
