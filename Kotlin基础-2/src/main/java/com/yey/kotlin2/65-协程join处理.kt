package com.yey.kotlin2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun main(args: Array<String>) {
    println(Thread.currentThread().name + "主线程执行")
    val job = coroutineScope {
        launch {
            (1..10).forEach {
                println("打印数据" + it)
                Thread.sleep(500)
            }
        }
    }
    job.join() // 将主线程与协程改为串行执行, 协程没有执行完,主线程不能执行.
    println(Thread.currentThread().name + "主线程结束执行")


}