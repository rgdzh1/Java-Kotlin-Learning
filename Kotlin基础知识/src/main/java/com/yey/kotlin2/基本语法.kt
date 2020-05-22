package com.yey.kotlin2.a

// 变量定义
var n: Int = 30  // Int 是数据类型
var ok = 20 // 自动推导
val m: Int = 20 //常量
var l = 30

// 函数定义
fun main(args: Array<String>) {
    println(add(10, 30))
}

/**
 * 定义函数
 */
fun add(a: Int, b: Int): Int {
    return a + b
}