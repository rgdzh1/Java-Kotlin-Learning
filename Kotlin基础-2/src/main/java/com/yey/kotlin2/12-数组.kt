package com.yey.kotlin2

import org.junit.Test

class Person {}
class `12-数组` {
    @Test
    fun 数组创建() {
        // 数组泛型为int
        var arr = arrayOf(1, 2, 3)
        // 数组泛型为char
        var arr1 = arrayOf('1', '2')
        //
        var arr2 = arrayOf("1", '2', 3)
        // 长度为10的int类型数组
        var arr3 = IntArray(10)
        // 创建长度为10的int类型数组,并且将其中每个元素都赋值为100
        var aar4 = IntArray(10) {
            100
        }
        // 8种基本类型都有对应的数组
        // String是没有对应的StringArray数组的,需要自己创建
        var aar5 = Array<String>(10) {
            ""
        }
        // 创建数组泛型为Person类型
        var aar6 = Array<Person>(10) {
            Person()
        }
    }

    @Test
    fun 数组修改() {
        var aar = IntArray(4)
        aar[0] = 1
        aar[1] = 2
        aar[2] = 3
        aar[3] = 4
//        aar[4] = 4 索引越界
        aar.forEach {
            println(it)
        }
        // 修改数组中值,两种方法
        aar[2] = 100
        aar.set(0, 109)
        // 数组遍历
        aar.forEach {
            println(it)
        }
    }

    @Test
    fun 数组元素角标查找() {
        var aar = arrayOf("m", "a", "b", "c", "b", "a")
        // 第一次出现a的索引
        val indexOf = aar.indexOf("a")
        // println(indexOf)

        // 最后出现"a"元素索引
        val lastIndexOf = aar.lastIndexOf("a")
        // println(lastIndexOf)

        // 高阶函数,
        val indexOfLast = aar.indexOfLast {
            // 返回true,
            it.startsWith("a")
        }
        println(indexOfLast)

        val indexOfFirst = aar.indexOfFirst {
            // 返回true,
            it.startsWith("a")
        }
        println(indexOfFirst)
    }

}