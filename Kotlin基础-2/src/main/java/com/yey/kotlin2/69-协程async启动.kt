package com.yey.kotlin2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main(args: Array<String>) {

    val job1 = coroutineScope {
        async {
            job1()
        }
    }
    val job2 = coroutineScope {
        async {
            job2()
        }
    }
    // 可以说async会阻塞主线程
    println(Thread.currentThread().name + "标记位1")// job1与job2执行完成之后才执行这里,说明主线程是被阻塞了.
    val str1 = job1.await()
    println(str1)
    println("标记位2")
    val str2 = job2.await()
    println(str2)
}

suspend fun job1(): String {
    println("开始执行job1")
    delay(2000)
    println("结束执行job1")
    return "job1"
}

suspend fun job2(): String {
    println("开始执行job2")
    delay(2000)
    println("结束执行job2")
    return "job2"
}