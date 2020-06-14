package com.yey.kotlin2

import kotlinx.coroutines.newFixedThreadPoolContext
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool

class MyRunnable :Runnable{
    override fun run() {
        (1..10).forEach{
            println("开始执行"+it)
            Thread.sleep(50)
        }
    }
}

fun main(args: Array<String>) {
    // 普通的线程池 主线程结束之后,可以继续执行
    // 普通的线程池创建的用户线程
//    val newFixedThreadPool = Executors.newFixedThreadPool(3)
//    newFixedThreadPool.execute(MyRunnable())
    // ForkJoinPool 主线程执行完之后ForkJoinPool里面的线程也结束了.
    // ForkJoinPool创建的是守护线程
    // 通过launch函数启动的协程运行在线程池中,该线程池中的线程默认是守护线程.
    val forkJoinPool = ForkJoinPool(3)
    forkJoinPool.execute(MyRunnable())
}