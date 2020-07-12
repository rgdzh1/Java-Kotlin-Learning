package com.yey.kotlin2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(args: Array<String>) {
    val job = coroutineScope {
        launch {
            println("1 执行开始,当前协程:${Thread.currentThread().name}")
            // 它是一个非阻塞式的,线程池中1线程执行到此处后1线程就会被线程池回收.
            // 当时间到了之后,可能线程池就会让线程4来继续向下执行协程代码块中的代码.
            delay(4000L)
            // 如果将delay改为sleep,那么这个线程将会在此处被阻塞,一直等到时间过后被唤醒再接着向下执行.
            // Thread.sleep(4000L)
            println("1 执行结束,当前协程:${Thread.currentThread().name}")
        }
        // 1线程可能被调用来执行次协程代码
        launch {
            println("2 执行开始,当前协程:${Thread.currentThread().name}")
            runTest()
            println("2 执行结束,当前协程:${Thread.currentThread().name}")
        }
        launch {
            delay(2000)
            println("3 执行结束,当前协程:${Thread.currentThread().name}")
        }
        launch {
            delay(2000)
            println("4 执行结束,当前协程:${Thread.currentThread().name}")
        }
    }
    println("主线程 执行结束,当前协程:${Thread.currentThread().name}")
    // 等待协程执行完毕主线程才结束
    job.join()
}

suspend fun runTest() {
    delay(2000)
    println("runTest 执行结束,当前协程:${Thread.currentThread().name}")
}
