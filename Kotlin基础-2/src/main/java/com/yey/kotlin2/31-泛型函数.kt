package com.yey.kotlin2

import org.junit.Test

class `31-泛型函数` {
    // 泛型函数
    // 和java一毛一样啊
    fun <T> parseType(things: T): T {
        when (things) {
            is Int -> {
                println("Int类型")
                return things
            }
            is String -> {
                println("String类型")
                return things
            }
            else -> {
                println("未知类型")
                return things
            }
        }
    }

    @Test
    fun 泛型函数(){
        parseType(10)
        parseType("222")
        parseType(10L)
    }
}