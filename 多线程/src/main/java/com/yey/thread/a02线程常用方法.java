package com.yey.thread;


import org.junit.Test;

/**
 * Thread.currentThread(): 获取当前线程
 * getName(): 获取当前线程名字
 * setName("子线程");为线程设置名字
 * yield();该方法释放当前线程CPU的执行权限.
 * join():在线程A中调用线程B的join(),此时线程A会进入阻塞状态,直到线程B完全执行完以后,线程A才结束阻塞状态,然后线程A抢到了CPU资源就可以继续执行了.
 * stop(): 强制结束当前线程
 * sleep():让当前线程睡眠
 * isAlive(): 判断当前线程是否存活
 */
public class a02线程常用方法 {
    class MyThread extends Thread {
        public MyThread() {
            super();
        }

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                // Thread.currentThread(): 获取当前线程
                // getName(): 获取当前线程名字
                System.out.println(Thread.currentThread().getName() + "***" + i);
                if (i % 10 == 0) {
                    // 该方法释放当前线程CPU的执行权限.
                    yield();
                }
            }
        }
    }

    @Test
    public void 测试() {
        MyThread myThread = new MyThread();
        // 为线程设置名字
        myThread.setName("子线程");
        myThread.start();

        MyThread myThread1 = new MyThread("构造命名子");
        myThread1.start();

    }
    class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                // Thread.currentThread(): 获取当前线程
                // getName(): 获取当前线程名字
                System.out.println(Thread.currentThread().getName() + "***" + i);
            }
        }
    }
    @Test
    public void join方法() throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if (i == 80) {
                // 在线程A中调用线程B的join(),此时线程A会进入阻塞状态,直到线程B完全执行完以后,线程A才结束阻塞状态,然后线程A抢到了CPU资源就可以继续执行了.
                myThread1.join();
            }
        }
    }
}
