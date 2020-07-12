package com.yey.xiecheng

import kotlinx.coroutines.*
import org.junit.Test

//class `04-线程切换` {
//    @Test
//    fun test() {
//        println("test 执行开始,当前协程:${Thread.currentThread().name}")
//        runBlocking {
//            println("GlobalScope 执行开始,当前协程:${Thread.currentThread().name}")
//            GlobalScope.launch {
//                withContext(Dispatchers.IO) {
//                    println("IO 执行开始,当前协程:${Thread.currentThread().name}")
//                }
//                println("GlobalScope 执行开始,当前协程:${Thread.currentThread().name}")
//                withContext(Dispatchers.IO) {
//                    println("IO 执行开始,当前协程:${Thread.currentThread().name}")
//                }
//                println("GlobalScope 执行开始,当前协程:${Thread.currentThread().name}")
//            }
//        }
//    }
//}

suspend fun main() {
    val coroutineScope = coroutineScope {
        10
    }
    println(coroutineScope)
}