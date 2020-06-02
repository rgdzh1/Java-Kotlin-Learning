package com.yey.kotlin2

import org.junit.Test

class `17-默认参数-具名参数-可变参数` {
    // 解决Java中的方法重载
    // method:String = "GET" : 默认参数
    fun sendRequest(path: String, method: String = "GET") {
        println("请求方式: $method 请求路径: $path")
    }

    @Test
    fun 默认参数与具名参数() {
        // 使用默认参数
        sendRequest("http://www.com")
        // 正常调用
        sendRequest("http://www.com", "POST")
        // 具名参数
        sendRequest(path = "http://www.com", method = "POST")
        sendRequest(method = "POST", path = "http://www.com")
    }

    @Test
    fun 可变参数() {
        // Kotlin中可变参数用vararg修饰, 传递的是一个数组
        // Java中用int ... 表示,传递的是数组
        println(adds(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    fun adds(vararg arr: Int): Int {
        var result = 0
        arr.forEach {
            result += it
        }
        return result
    }
}