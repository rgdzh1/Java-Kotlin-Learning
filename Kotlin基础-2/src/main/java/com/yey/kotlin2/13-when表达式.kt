package com.yey.kotlin2

import org.junit.Test

class `13-when表达式` {
    @Test
    fun test() {
        val result = when表达式增强(10)
        println(result)
        val when表达式不要参数 = when表达式不要参数(1)
        println(when表达式不要参数)
    }

    fun when表达式增强(age: Int): String {
        when (age) {
            in 1..6 -> return "还在吃奶"
            7 -> {
                return "刚刚上小学"
            }
            8, 9 -> {
                return "上小学一年级"
            }
            in 10..50 -> {
               return "打豆豆"
            }
            else -> return "都不符合"
        }
    }

    fun when表达式不要参数(age: Int): String {
        return when {
            age in 1..6 ->  "还在吃奶"
            age == 7 -> {
                return "刚刚上小学"
            }
            age in 8..9 -> {
                // 在Labmda表达式中,大括号中的最后一行代码就是返回值
                // 在上面的带参数的when表达式中,不能用这种方式表示返回值,不然报错.
                "打豆豆"
            }
            // 必须最后要一个else
            else -> "都不符合"
        }
    }
}