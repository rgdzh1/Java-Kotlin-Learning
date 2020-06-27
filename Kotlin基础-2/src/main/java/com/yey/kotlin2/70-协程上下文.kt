package com.yey.kotlin2


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext

suspend fun main(args: Array<String>) {
    GlobalScope.launch() {
        println("当前线程${Thread.currentThread().name}")
    }
    GlobalScope.launch() {
        println("当前线程${Thread.currentThread().name}")
    }
    coroutineScope {
        launch(newFixedThreadPoolContext(3, "新协程")) {
            println("当前线程${Thread.currentThread().name}")
        }
    }
}