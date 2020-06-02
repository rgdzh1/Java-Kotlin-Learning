package com.yey.kotlin2

import org.junit.Test

class `15-函数引用` {
    // 函数表达式
    fun add(a: Int, b: Int): Int = a + b

    @Test
    fun 函数引用() {

        // add2就是函数的引用,可以看出来它的类型是函数类型
        val add2 = ::add
        // 调用方式1
        val result = add2(10, 20)
        println(result)
        // 调用方式2
        // 使用invoke调用函数引用,可以使用安全调用符号,
        // 因为函数引用可能为null,使用?.防止报错
        add2?.invoke(10, 20)
    }
}