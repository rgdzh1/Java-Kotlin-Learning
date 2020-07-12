package com.yey.xiecheng

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import javax.xml.bind.JAXBElement

class `03-初识协程` {
    @Test
    fun runTest() {
        println("主线程 执行开始,当前协程:${Thread.currentThread().name}")
        GlobalScope.launch {
            println("launch 执行开始,当前协程:${Thread.currentThread().name}")
            waitMethed()
            waitMethed()
            waitMethed()
            waitMethed()
            println("launch 执行结束,当前协程:${Thread.currentThread().name}")

        }
        println("Hello")
        Thread.sleep(30000)
        println("World")
        println("主线程 执行结束,当前协程:${Thread.currentThread().name}")
    }

    private suspend fun waitMethed() {
        println("waitMethed 执行开始,当前协程:${Thread.currentThread().name}")
        delay(2000)
        println("waitMethed 执行结束,当前协程:${Thread.currentThread().name}")

    }
}

fun main() {
    println("main 执行开始,当前协程:${Thread.currentThread().name}")
    runBlocking {
        println("runBlocking 执行开始,当前协程:${Thread.currentThread().name}")
        GlobalScope.launch {
            println("GlobalScope.launch 执行开始,当前协程:${Thread.currentThread().name}")
            delay(1000)
            println("Kotlin Coroutines")
            println("GlobalScope.launch 执行结束,当前协程:${Thread.currentThread().name}")
        }
        println("Hello")
        delay(2000)
        println("World")
        println("runBlocking 执行结束,当前协程:${Thread.currentThread().name}")
    }
    println("main 执行结束,当前协程:${Thread.currentThread().name}")
}