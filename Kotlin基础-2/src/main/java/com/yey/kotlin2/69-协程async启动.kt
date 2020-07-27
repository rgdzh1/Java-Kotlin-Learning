package com.yey.kotlin2

import kotlinx.coroutines.*
import sun.applet.Main

suspend fun main(args: Array<String>) {
    coroutineScope {
        val async1 = async {
            job1()
        }
        val async2 = async {
            job2()
        }
//        val result1 = async1.await()
//        val result2 = async2.await()
//        println(result1 + "   " + result2)
    }
    println(Thread.currentThread().name + "标记位1")// job1与job2执行完成之后才执行这里,说明主线程是被阻塞了.
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