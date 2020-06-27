package com.yey.kotlin2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 挂起函数:可以被挂起执行,到时候再自动切换回来的切线程
 * 另外一种说法,可以被挂起执行,到时间之后从线程池中空闲的线程中恢复执行.
 */
suspend fun main(args: Array<String>) {
    val job = coroutineScope {
        launch {
            delay(8000L)
            println("launch1")
//            println("执行开始,当前协程:${Thread.currentThread().name}")
            // delay将协程挂起, 到时间之后再从线程池中拿一条空线程出来继续执行.
//            delay(8000L)
//            println("执行结束,当前协程:${Thread.currentThread().name}")
        }
        println("1$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        // 1线程可能被调用来执行次协程代码
        launch {
            delay(8000)
            println("launch2")
        }
        println("2$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        launch {
            delay(8000)
            println("launch3")
        }
        println("3$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        launch {
            delay(8000)
            println("launch4")
        }
    }
    // 等待协程执行完毕主线程才结束
    job.join()
}