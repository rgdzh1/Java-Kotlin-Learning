package com.yey.kotlin2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 挂起函数:可以被挂起执行,到时候再自动切换回来的切线程
 */
suspend fun main(args: Array<String>) {
    val job = coroutineScope {
        launch {
            println("执行开始,当前协程:${Thread.currentThread().name}")
            // delay将协程挂起, 到时间之后再从线程池中拿一条空线程出来继续执行.
            delay(4000L)
            println("执行结束,当前协程:${Thread.currentThread().name}")
        }
        // 1线程可能被调用来执行次协程代码
        launch {
            delay(2000)
        }
        launch {
            delay(2000)
        }
        launch {
            delay(2000)
        }
    }
    // 等待协程执行完毕主线程才结束
    job.join()
}