package com.yey.kotlin2

import org.junit.Test
import java.util.*

class `14-函数表达式` {
    // Kotlin中函数体只有一行,这样的函数就可以简化写
    fun add(a1: Int, a2: Int): Int = a1 + a2
    fun myPrint(str: String) = println(str)

    @Test
    fun test(){
        println(add(1,10))
        println(myPrint("查看"))
    }

}