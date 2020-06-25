package com.yey.thread;

import org.junit.Test;

/**
 * wait() 当前线程执行此方法之后就会被阻塞,并释放锁.
 * notify() 会唤醒一个被阻塞的线程,如果当前阻塞的线程有多个,将唤醒优先级高的线程.
 * notifyAll() 换新所有被阻塞的线程
 * wait(),notify(),notifyAll() 这三个方法必须在同步代码块或者同步方法中由锁调用他们,如果不是 由锁去调用他们会抛出异常的.
 */

/**
 * sleep() 与 wait() 异同?
 * 相同点: 都可以使当前线程进入阻塞状态
 * 不同点: sleep()可以在任何需要的场景下调用,wait()必须在同步代码块或者同步方法中使用锁来调用.
 *        sleep()和wait()都在同步代码块或者同步方法中调用, sleep()不会释放锁,但是wait()会释放锁.
 */
public class a12线程通信 {
    class Window implements Runnable {
        private int ticket = 100;

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    notify();
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
//        new Thread(window).start();
    }
}
