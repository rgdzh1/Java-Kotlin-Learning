package com.yel2

fun main(args: Array<String>) {
    var str1 = "abc"
    var str2 = String(charArrayOf('a','b','c'))
    println(str1.equals(str2))// 比较值
    println(str1 == str2)// 比较值
    println(str1 === str2)// === 比较地址值
    // 不过在java中equals是值比较,== 是地址值比较,这点与Kotlin不太一样
}

