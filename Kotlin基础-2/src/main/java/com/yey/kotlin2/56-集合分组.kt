package com.yey.kotlin2

import org.junit.Test

class `56-集合分组` {
    @Test
    fun 集合分组() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三", "李王五", "孙李四")
        // 不同的姓氏分成不同组
        val groupBy = listOf1.groupBy {
            val surname = it.substring(0, 1)
            when (surname) {
                "张" -> "张"//如果该元素姓张就返回张
                "李" -> "李"
                else -> "其他"
            }
        }
        println(groupBy)
    }
}