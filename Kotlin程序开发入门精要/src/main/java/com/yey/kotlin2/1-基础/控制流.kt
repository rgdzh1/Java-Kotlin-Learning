package com.yey.kotlhhh

// 条件语句
fun main(args: Array<String>) {
//    ifDemo()
//    whenDemo(4)
//    forDemo()
    whileDemo()
}

// 传统if语句用法
fun ifDemo1() {
    var a: Int = 20
    var b = 30
    var max: Int = 0
    if (a < b) max = b
    println("最大值$max")
    var min = 0
    if (a > b) {
        min = b
    } else {
        min = a
    }
    println("最小值$min")
}

// if语句作为表达式使用
fun ifDemo() {
    var a = 30
    var b = 38
    val max = if (a > b) a else b
    println("最大值 $max")

    val min = if (a > b) {
        println("Choose a")
        b// 返回值
    } else {
        println("Choose b")
        a// 返回值
    }
    println("最小值$min")
}

// when语句普通使用
fun whenDemo2(x: Int) {
    when (x) {
        1 -> {
            println("x = 1")
            println("正确执行1分支")
        }
        2 -> println("正确执行2分支")
        3, 4 -> println("正确执行分支3或者4") //如果多个分支条件执行代码都一样的话用逗号分隔.
        else -> {
            println("没有匹配到分支")
        }
    }
}

// when 使用in关键字
fun whenDemo3(x: Int) {
    when (x) {
        in 1..20 -> println("条件从1-20")// in 表示一个范围,!in 表示不在这个范围中
        in 11..20 -> println("条件从20-30")
//        !in 90..100 -> println("条件不是90-100")
        else -> {
            println(
                """所有的都不符
                |合
                |条
                |件""".trimMargin()
            )
        }
    }
}


fun getValue(x: Int): Int {
    return x * x
}

// when 当条件是函数
fun whenDemo(x: Int) {
    when (x) {
        getValue(2) -> {
            println("when 条件分支是函数返回的值 4")
        }
        getValue(3) -> println("条件为3不符合条件")
        else -> println("什么条件都不符合")
    }
}

// for循环
fun forDemo1() {
    var arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    for (i: Int in arr) {
        println(i)
    }
}

// 根据索引遍历
fun forDemo2() {
    var arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in arr.indices) {
        if (i == 0) {
            continue // 跳出i=0时候的逻辑
        }
        println("arr[$i]==${arr[i]}")
    }
}

// 同时对索引与元素进行循环
fun forDemo() {
    var arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for ((index, value) in arr.withIndex()) {
        if (value == 5) // value ==5 跳出循环
            break
        println("arr[$index] == $value")
    }
}

// while
fun whileDemo1() {
    var i = 0
    while (i++ < 10) {
        println(i)
    }
}

fun whileDemo() {
    var i = 0
    do {
        println(i)
    } while (i++ < 50)
}
