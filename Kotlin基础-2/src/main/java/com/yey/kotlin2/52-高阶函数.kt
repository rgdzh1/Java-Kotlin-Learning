package com.yey.kotlin2

import org.junit.Test

class `52-高阶函数` {
    // 工具方法 求和
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // 工具方法 求差
    fun sub(a: Int, b: Int): Int {
        return a - b
    }

    // 高阶函数,给参数与函数,自动得到结果
    /***
     * (Int,Int)->Int: 这个类型是函数类型其中(Int,Int)为参数类型,->Int为该函数的返回值类型,
     * 函数类型的参数需要接收该函数的地址值.
     */
    fun cacl(a: Int, b: Int, util: (Int, Int) -> Int): Int {
//        return util(a, b)
        return util.invoke(a, b)//invoke()就是调用方法
    }

    @Test
    fun 高阶函数() {
        // :: 表示某个成员的引用,写在方法前面就是方法的引用
        val cacl = cacl(10, 20, ::sub)
        println(cacl)
        println(cacl(10, 60, ::add))
    }
}