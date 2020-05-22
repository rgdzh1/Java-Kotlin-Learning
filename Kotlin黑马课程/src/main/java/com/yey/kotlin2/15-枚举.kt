package com.yey.kotlin2h

enum class Week {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

fun main(args: Array<String>) {
    println(Week.星期一.ordinal) // 打印枚举序列
    println(Week.星期二.ordinal) // 打印枚举序列
    println(Week.星期三.ordinal) // 打印枚举序列
    println(Week.星期四.ordinal) // 打印枚举序列
    println(Week.星期五.ordinal) // 打印枚举序列
    println(Week.星期六.ordinal) // 打印枚举序列
    println(Week.星期日.ordinal) // 打印枚举序列
}
