package com.yey.kotlin2

fun main(args: Array<String>) {
    // 先进行条件判断,再执行
    var count = 100
    while (count > 0) {
        count--
        println(count)
    }
    // 先执行do中的操作,再判断条件是否允许,允许继续执行,不允许就不继续执行.
    var count1 = -100
    do {
        count1--
        println(count1)
    } while (count1 > 0)
}