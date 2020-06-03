package com.yey.kotlin2

import org.junit.Test

class `35-中缀表达式` {
    // 中缀表达式的条件
    // 1 必须是成员函数
    // 2 必须只有一个参数
    // 3 参数不能是可变参数vararg或者默认参数
    class Person {
        infix fun myPrint(str: String) {
            println(str)
        }
    }

    @Test
    fun 中缀表达式() {
        // 中缀表达式的作用就是使得编程语言更接近自然语言
        Person() myPrint "说话"
        // 二元元組创建
        val pair = "a" to "b" // 可以看看它是如何实现的
        // 泛型A调用to(泛型)方法,创建一个Pair类型的对象,成员属性中有两个泛型类型属性
        // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    }
}