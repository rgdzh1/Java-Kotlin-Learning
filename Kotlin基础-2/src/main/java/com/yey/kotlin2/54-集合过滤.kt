package com.yey.kotlin2

import org.junit.Test

class `54-集合过滤` {
    @Test
    fun 集合过滤() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三")
        val listOf2 = listOf<String>("钱张三", "孙李四", "李王五", "吴赵二")
        // 将集合中新张的过滤出来存入一个新集合中
        // filter()返回一个新集合
        val newList = listOf1.filter {
            it.startsWith("张")
        }
        println(newList)
    }

    @Test
    fun 集合查询() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三")
        val listOf2 = listOf<String>("钱张三", "孙李四", "李王五", "吴赵二")
        // 找到集合中第一个姓张的
        // find 返回一个新的字符串
        val str = listOf1.find {
            it.startsWith("李")
        }
        println(str)
    }
    @Test
    fun 找到两个集合中需要的元素放入新集合中() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三")
        val listOf2 = listOf<String>("钱张三", "孙李四", "李王五", "吴赵二")
        val resultList = mutableListOf<String>()
        listOf1.filterTo(resultList,{
            it.startsWith("王")
        })
        listOf2.filterTo(resultList,{
            it.startsWith("钱")
        })
        println(resultList)
    }

    @Test
    fun 元素中角标为偶数的找出() {
        val listOf1 = listOf<String>("张三", "李四", "王五", "赵二", "张张三")
        val listOf2 = listOf<String>("钱张三", "孙李四", "李王五", "吴赵二")
        val resultList = listOf1.filterIndexed { index, s ->
            index % 2 == 0//返回true就将元素加入新的集合中
        }
        println(resultList)
    }

}