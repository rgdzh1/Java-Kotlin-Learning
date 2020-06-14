package com.yey.kotlin2;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Runnable可以实现线程间的数据共享操作
class TicketRunnable implements Runnable {
    private int ticketCount = 100;

    @Override
    public void run() {
        while (ticketCount > 0) {
            // 原子操作
            synchronized (TicketRunnable.class) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + ticketCount + "张票");
                --ticketCount;
            }
        }
    }
}

public class Java线程 {
    @Test
    public void 线程安全() {
        TicketRunnable ticketRunnable = new TicketRunnable();
        Thread thread = new Thread(ticketRunnable);
        thread.setName("窗口一");
        Thread thread1 = new Thread(ticketRunnable);
        thread1.setName("窗口二");
        Thread thread2 = new Thread(ticketRunnable);
        thread2.setName("窗口三");
        thread.start();
        thread1.start();
        thread2.start();
    }

    // 将主线程与子线程的并发操作变为串行执行
    @Test
    public void 线程join() throws InterruptedException {
        System.out.println("主线程开始执行");
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子子子线程执行" + i);
                }
            }
        };
        thread.start();
//        thread.join(); // 主线程正在执行中,子线程执行join后,主线程必须等到子线程执行完毕后才能接着执行
        System.out.println("主线程结束执行");
    }

    @Test
    public void 守护线程() {
        // 主线程结束,守护线程结束
        // 守护线程是指子程序运行时在后台提供一种通用的服务线程.例如Java的垃圾回收线程就是守护线程.
        System.out.println("主线程开始执行");
        System.out.println("主线程结束执行");
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("子子子线程执行" + i);
                }
            }
        };
        thread.setDaemon(true);// 守护线程必须在线程运行之前设置,当主线程结束它就自动结束了.
        thread.start();
    }

    // 当程序中要使用大量生命周期很短的线程时,应该考虑线程池
    // 线程池中每一个线程代码结束后,并不会销毁,而是再次回到线程池中成为空闲状态,等待下一个对象来使用.
    // JDK5以前需要自己实现线程池,JDK5开始JAVA内置了一个线程池.
    @Test
    public void 线程池() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);//一般是机器的核心数+1或者-1条线程
        TicketRunnable ticketRunnable = new TicketRunnable();
        executorService.submit(ticketRunnable);
        executorService.submit(ticketRunnable);
        executorService.submit(ticketRunnable);
        executorService.submit(ticketRunnable);
    }
}
