package com.yey.kotlin2q


// food: String? 加问号表示food参数可以接收null
fun eat(food: String?): String {
    return "吃 " + food
}

// 类型后没有?, 表示不可以接收null
fun sleep(time: Int) {
    println("睡 " + time + " 分钟")
}

fun main(args: Array<String>) {
    println(eat(null))// 参数类型后加了?,就可以接收null
    sleep(10)
//    sleep(null) //类型后没有?,不能接收null
}