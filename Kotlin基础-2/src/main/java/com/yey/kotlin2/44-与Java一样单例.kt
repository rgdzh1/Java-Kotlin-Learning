package com.yey.kotlin2

import org.junit.Test

class `44-与Java一样单例` {
    class Person {
        // 非静态
        var name: String = "李四"

        // 静态
        companion object {
            var age = 10

            // by lazy 懒加载
            // 线程安全
            // 只会加载一次
            val instance: Person by lazy {
                Person()
            }
        }
    }

    @Test
    fun 类似Java中单例() {
        println(Person.instance.name)
        println(Person.age)
    }
}