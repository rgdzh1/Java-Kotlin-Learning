package com.yey.kotlih

import java.lang.Exception

fun main(args: Array<String>) {
    while (true) {
        println("请输入第一个数字:")
        var num1str = readLine()
        println("请输入第二个数字:")
        var num2str = readLine()
        try {
            var num1 = num1str!!.toInt()// !! 表示num1str不可能为空
            var num2 = num2str!!.toInt()
            println("$num1 + $num2 = ${num1 + num2}")
        } catch (e: Exception) {
            println("您输入的数据有误请重新输入!")
        }
    }

}

