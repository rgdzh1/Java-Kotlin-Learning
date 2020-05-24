package com.yey.kotlin2w

fun main(args: Array<String>) {
    // 定义1-200的数组
    var nums = 1..100
    var count = 0
    for (i in nums) {
        count = count + i
    }
    println("结果" + count)
}