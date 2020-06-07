package com.yey.kotlin2

import org.junit.Test

class `45-枚举` {
    enum class WEEK {
        星期1, 星期2, 星期3, 星期4, 星期5, 星期6, 星期7,
    }

    @Test
    fun 打印枚举元素() {
        println(WEEK.星期1)
    }

    @Test
    fun 遍历枚举() {
        val results = WEEK.values()
        results.forEach {
            println(it)
        }
    }

    @Test
    fun 测试枚举When() {
        whenEnum(WEEK.星期7)
    }

    fun whenEnum(week: WEEK) {
        when (week) {
            WEEK.星期1 -> println(week)
            in WEEK.星期2..WEEK.星期5 -> println(week)
            WEEK.星期6, WEEK.星期7 -> println(week)
        }
    }

    // 高级枚举,枚举中定义构造函数
    enum class COLOR(var r: Int, var b: Int, var g: Int) {
        // RED,BLUE,GREEN对象的类型都是COLOR类型
        // COLOR构造方法中传入r,b,g三个参数,然后COLOR类型的对象就有这三个属性,用枚举对象就可以访问自身的三属性.
        RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0)
    }

    @Test
    fun 访问枚举元素的变量() {
        println(COLOR.BLUE.b)
        println(COLOR.GREEN.b)
        println(COLOR.GREEN.b)
    }

}