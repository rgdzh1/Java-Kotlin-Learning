package com.yey.kot5555

fun main(args: Array<String>) {
    // 定义二元元组
    val pair = Pair<String, Int>("张三", 15)
    val pair1 = "张三" to 15
    println(pair.first)
    println(pair1.second)
    // 定义三元元组
    val triple = Triple<String, Int, Int>("李四", 20, 1881145632)
    println(triple.first)
    println(triple.second)
    println(triple.third)
}

