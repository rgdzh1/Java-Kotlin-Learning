package com.yey.kotlin2e

fun main(args: Array<String>) {
    // 左闭右开区间
    var nums = 1 until 5
    nums.reversed()
    for (i in nums) {
        println(i)
    }
    println("集合中元素" + nums.count())
}

