package com.yey.kotlin2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.ForkJoinPool

/**
 * launch: 是一个函数 协程需要launch函数启动
 * launch函数中的参数context,start都是默认参数,参数值可以不用自己指定
 * launch函数最后一个参数是函数类型可以使用lambda表达式传入
 * launch函数的返回值是Job类型,它就是协程任务.
 * launch函数第一个参数:context: CoroutineContext = EmptyCoroutineContext,他是一个默认参数
 * CoroutineContext: 其实是一个CommonPool类型的对象
 * CommonPool类型就是通过Executors.newFixedThreadPool()也就是线程池来实现的.协程就是在线程池中执行的.
 * launch函数第一个参数就是告诉协程要运行在哪个线程池当中.
 */
suspend fun main(args: Array<String>) {
    coroutineScope {
        withContext(Dispatchers.IO){

        }
        launch {
            (1..10).forEach {
                println("打印数据" + it)
                Thread.sleep(500)
            }
        }
    }
}