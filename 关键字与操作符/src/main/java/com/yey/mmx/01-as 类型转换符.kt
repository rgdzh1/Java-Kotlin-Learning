package com.yey.mmx

import org.junit.Test

class `01-as 类型转换符` {
    @Test
    fun test() {
        // 不安全的转换操作符(as)
        var str = null
        // 如果str为null, 使用转换操作符as,代码运行时会提示:
        // null cannot be cast to non-null type kotlin.String(null无法转为非null的String)
        // val s = str as String
        // 要解决这个运行时报错问题,可以在String后加?,表示String为可空类型.
        var s = str as String?

        // as另外一个用处是为导入的包重新起一个别名
    }
    @Test
    fun test1(){
        // 安全的转换操作符(as?),它可以在失败的时候返回null,而不是抛出异常
        var str = null
        // 虽然右侧String是非空类型,转换失败了会返回null
        var s = str as? String
        println(s)// 打印null
    }

    @Test
    fun test2(){
        var str = "2"
        str = str as String
        println(str)
    }
}