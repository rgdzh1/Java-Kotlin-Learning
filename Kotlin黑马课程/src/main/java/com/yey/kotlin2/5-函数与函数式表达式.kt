package com.yey.kotlin2t

fun main(args: Array<String>) {
    println(add(1, 2))
    println(dda(1, 2))
    var add1 = { x: Int, y: Int -> x + y }
    println(add1(5, 10))
    var add2: (Int, Int) -> Int = { x, y -> x + y }
    println(add2(20, 60))

}

// 简写
fun add(x: Int, y: Int): Int = x + y

// 类似
fun dda(x: Int, y: Int): Int {
    return x + y
}