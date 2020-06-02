package com.yey.kotlin2

import org.junit.Test

class `11-区间` {
    @Test
    fun test() {
        // 定义1到100
        var range1 = 1..100
        var range2 = IntRange(1, 100)
        var rang3 = 1.rangeTo(100)
        for (i in range1) {
            println(i)
        }

        // 定义字符区间
        var range4 = 'a'..'z'
        var range5 = CharRange('a', 'z')
        var range6 = 'a'.rangeTo('z')
        // 区间遍历
        for (c in range4) {
            println(c)
        }
        range4.forEachIndexed { index, c ->
            println("索引: $index  值: $c")
        }
    }

    @Test
    fun 反向区间() {
        var range = 100..1
        // 打印试试,结果什么都没有
        for (i in range) {
            println(i)
        }
        // 正确的定义100..1,反向区间
        var range1 = 100 downTo 1
        for (i in range1) {
            println(i)
        }
    }
    @Test
    fun 区间反转(){
        var range = 1..100
        // reversed():对区间进行反转
        var range1 = range.reversed()
        // step 2 : 跳过第二个元素
        for (i in range1 step 2) {
            println(i)
        }
    }
}
