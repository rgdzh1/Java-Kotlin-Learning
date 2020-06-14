package com.yey.kotlin2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


/**
 * 1. 协程是什么?协程就是切线程.
 * 2. 挂起是什么?挂起就是可以自动切回来的切线程
 * 3. 非阻塞式:函数调用没有结束,线程可以被收回,当函数需要线程,通知一下线程,线程马上能接着执行.
 * 4. 阻塞:函数调用结果返回之前,当前线程会被挂起,函数只有在得到结果之后线程才能返回.
 * 5. 同步:调用函数,没有得到结果之前,该调用就不反回.
 * 6. 异步:调用函数后,调用者不能立刻得到结果,函数通过状态,通知和回调来通知调用者
 */
suspend fun main(args: Array<String>) {
    println(Thread.currentThread().name + "主线程执行")
    coroutineScope {
        launch {
            (1..10).forEach {
                println(Thread.currentThread().name + "打印数据" + it)
                Thread.sleep(500)
            }
        }
    }
    println(Thread.currentThread().name + "主线程结束执行")
    Thread.sleep(5000L)
}

