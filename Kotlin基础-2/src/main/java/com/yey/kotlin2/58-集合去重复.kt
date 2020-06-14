package com.yey.kotlin2

import org.junit.Test

class `58-集合去重复` {
    @Test
    fun set集合去除重复() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三","张三","李四")
        // 转为set集合自动去重
        val toSet = listOf1.toSet()
        println(toSet)
    }
    @Test
    fun distinct去重() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三","张三","李四")
        val distinct = listOf1.distinct()
        println(distinct)
    }
    @Test
    fun 去除姓重复的() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三","张三","李四")
        val distinctBy = listOf1.distinctBy {
            it.substring(0, 1)// 根据lambda表达式返回的值进行去重
        }
        println(distinctBy)
    }
}