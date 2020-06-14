package com.yey.kotlin2

import org.junit.Test

class `57-集合最值` {
    @Test
    fun 最值() {
        val listOf = listOf<Int>(1, 5, 6)
        // 最大值
        val max = listOf.max()
        println(max)
        // 最小值
        val min = listOf.min()
        println(min)
    }

    @Test
    fun 字段最值() {
        val listOf = listOf<Person>(Person("张三", 20), Person("李四", 30), Person("王五", 10))
        // 字段最小最值
        val minBy = listOf.minBy {
            it.age
        }
        println(minBy)
        // 字段最大最值
        val maxBy = listOf.maxBy {
            it.age
        }
        println(maxBy)
    }

    data class Person(var name: String, var age: Int)
}