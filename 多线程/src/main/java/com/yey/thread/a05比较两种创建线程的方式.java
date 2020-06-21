package com.yey.thread;

public class a05比较两种创建线程的方式 {
    /**
     * 开发中优先使用实现Runnable接口的方式
     * 原因: 1. 实现的方式没有类的单继承性的局限性
     *      2. 实现的方式更适合用来处理多个线程有共享数据的情况
     * 相同: 两种方法都需要重写run(), 线程执行的逻辑写在run()方法中
     * 联系: Thread也实现了Runnable接口
     * public class Thread implements Runnable {}
     */
}
