package com.yey.thread;

import org.junit.Test;

/**
 * MIN_PRIORITY = 1; 最小优先级
 * NORM_PRIORITY = 5; 默认优先级
 * MAX_PRIORITY = 10; 最大优先级
 * 优先级越高抢到CPU执行权概率越高.
 */
public class a03线程优先级 {
    @Test
    public void 获取线程优先级() {
        // 获取优先级
        int priority = Thread.currentThread().getPriority();
        System.out.println(priority);
    }

    @Test
    public void 设置优先级(){
        // 设置优先级
        Thread.currentThread().setPriority(9);
        int priority = Thread.currentThread().getPriority();
        System.out.println(priority);
    }
}
