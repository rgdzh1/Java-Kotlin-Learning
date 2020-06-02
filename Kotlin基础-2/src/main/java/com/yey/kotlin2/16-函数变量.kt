package com.yey.kotlin2

import org.junit.Test

class `16-函数变量` {
    @Test
    fun 函数变量() {
        // (Int, Int) -> Int 这个就叫做函数类型
        // 分别为:参数类型,参数类型,返回值类型
        // 属于匿名函数
        val add1: (Int, Int) -> Int = { a, b -> a + b }
        println(add1(12, 20))
    }
}