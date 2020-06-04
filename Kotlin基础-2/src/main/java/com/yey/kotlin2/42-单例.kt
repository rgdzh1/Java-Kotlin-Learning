package com.yey.kotlin2

import org.junit.Test
import org.omg.CORBA.PERSIST_STORE

class `42-单例` {
    // 单例: 在类名前面添加object
    // object 单例中,所有的字段都是静态的
    object Person {
        var name = "张三"
        var age = 50
        fun sayHello() {
            println("Hello")
        }
    }

    @Test
    fun 单例() {
        // 单例的调用很简单,就使用类名就可以了.
        println(Person.age)
        println(Person.name)
        Person.sayHello()
    }
}