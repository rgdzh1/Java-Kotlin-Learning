package com.yey.kotlin2

import org.junit.Test

class `59-集合拆分组合相加` {
    @Test
    fun 集合拆分() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三", "张三", "李四")
        // 返回一个二元组,其中两个元素都是集合
        val partition = listOf1.partition {
            it.startsWith("张")//姓张的单独一部分
        }
        println(partition.first)
        println(partition.second)
    }

    @Test
    fun 集合重新组合() {
        val listOf = listOf<Person>(Person("张三", 20), Person("李四", 30), Person("王五", 10))
        val map = listOf.map {
            it.age//将age加入新的集合
        }
        println(map)
    }
    data class Person(var name: String, var age: Int)

    @Test
    fun 集合相加() {
        val listOf = listOf<Person>(Person("张三", 20), Person("李四", 30), Person("王五", 10))
        val sumBy = listOf.sumBy {
            it.age
        }
        println(sumBy)
    }

}