package com.yey.kotlin2

import org.junit.Test
import org.omg.CORBA.PERSIST_STORE

class `55-集合排序` {
    @Test
    fun 排序() {
        val listOf = listOf<Int>(1, 5, 6)
        // 正序排序
        val sorted = listOf.sorted()
        println(sorted)
        // 倒序排序
        val sortedDescending = listOf.sortedDescending()
        println(sortedDescending)
    }

    @Test
    fun 字段排序() {
        val listOf = listOf<Person>(Person("张三", 20), Person("李四", 30), Person("王五", 10))
        // 正序字段排序
        val sortedBy = listOf.sortedBy {
            it.age
        }
        println(sortedBy)
        // 倒序字段排序
        val sortedByDescending = listOf.sortedByDescending {
            it.age
        }
        println(sortedByDescending)
    }

    data class Person(var name: String, var age: Int)
}