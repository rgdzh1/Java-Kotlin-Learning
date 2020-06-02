package com.yey.kotlin2

import org.junit.Test

class `19-类的属性操作` {
    class Person {
        var name = "张三"
        var age = 20
    }

    @Test
    fun 默认实现了set与get方法() {
        // 类中只要定义了属性,Kotlin就自动实现了属性的set与get方法,java中需要自己手动定义
        var p = Person()
        println(p.age)
        println(p.name)
        p.age = 100
        p.name = "李四"
        println(p.age)
        println(p.name)
    }

    class Student {
        var name = "张三"
        private set
        var age = 20
    }


    @Test
    fun 禁用get方法() {
        val s = Student()
        // s.name = "张三" 编译器此时就报错,因为name属性的set方法被禁止了
        println(s.name)
        s.age = 200
        println(s.age) // age属性的set方法与get方法都是可以使用的
    }
}