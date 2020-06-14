package com.yey.kotlin2

import org.junit.Test

class `61-Kotlin中函数回调` {
    // 不同于Java中的接口回调, Kotlin中可以是函数回调
    // Java中是客户端传入一个对象过去, 而Kotlin中将该对象改为了函数而已.
    // Person类中将参数传入回调函数中,客户端中定义该函数如何处理.
    class Person() {
        fun eat(block: (String) -> Unit) {
            block("大白菜")// Person类将函数传入
        }
    }

    @Test
    fun 函数回调() {
        Person().eat {
            println("今天吃" + it)// 客户端处理Person类中传入的参数
        }
    }

}