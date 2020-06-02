package com.yey.kotlin2

fun main(args: Array<String>) {
    var str = "123456"
    breakFun(str)

    continueFun(str)
    // 高级for循环中是不允许使用continue与break的
    str.forEachIndexed { index, c ->
        if (index == 2) {
//            continue
//            break
        }
    }
}

private fun continueFun(str: String) {
    for (c in str) {
        if (c == '3') {
            continue // 跳出循环
        }
        println("continueFun  " + c)
    }
}

private fun breakFun(str: String) {
    for (c in str) {
        if (c == '3') {
            break // 跳出循环
        }
        println("breakFun  " + c)
    }
}