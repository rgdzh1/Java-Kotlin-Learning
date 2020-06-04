package com.yey.kotlin2

import org.junit.Test


class `40-lateinit 延迟加载` {
    // 延迟加载
    class Person {
        // 不确定, 后面才会被赋值.不赋值使用会报错(lateinit property name has not been initialized)
        // 如果不加lateinit,那么属性没有值会编译报错
        lateinit var name: String
    }
    @Test
    fun 延迟加载(){
        val person = Person()
        person.name = "张三"
        println(person.name)
    }
}