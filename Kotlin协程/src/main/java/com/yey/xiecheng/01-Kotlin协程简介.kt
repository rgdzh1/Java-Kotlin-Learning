package com.yey.xiecheng

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/*
Kotlin在JVM上的协程是一个线程框架
*/
suspend fun main() {
    println(Thread.currentThread().name + "主线程执行")
    coroutineScope {
        launch(Dispatchers.IO) {
            println(Thread.currentThread().name)
            (1..100).forEach {
                println(it)
                Thread.sleep(100)
            }
        }
    }
    println(Thread.currentThread().name + "主线程结束")
}