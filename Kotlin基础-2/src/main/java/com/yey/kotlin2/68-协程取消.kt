package com.yey.kotlin2

import kotlinx.coroutines.*

suspend fun main(args: Array<String>) {
    println(Thread.currentThread().name + "主线程执行")
    var job = coroutineScope {
        println("当前协程状态 ${this.isActive}")
        launch {
            // withTimeout 也可以定义指定的时间之后结束
            //withTimeout(2000) {
            (1..100).forEach {
                println(Thread.currentThread().name + "打印数据" + it)
//                    delay(200)
            }
            //}
        }
    }

//    job.cancel()//协程取消,这个方法只能取消挂起的函数,阻塞式的无法取消.
    // 获取当前协程的状态
    job.cancel()
    println("当前协程状态 ${job.isActive}")
    println(Thread.currentThread().name + "主线程结束执行")

}
