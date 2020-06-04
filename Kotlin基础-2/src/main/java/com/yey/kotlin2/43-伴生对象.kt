package com.yey.kotlin2

import org.junit.Test

class `43-伴生对象` {
    class Person {
        // 伴生对象的作用就是解决字段的静态属性问题
        var age = 10

        companion object {
            // 存在于 companion object{}当中的字段就是静态的
            var name = "张三"
        }
    }

    @Test
    fun 伴生对象() {
        // 访问非静态属性
        val person = Person()
        println(person.age)
        // 访问静态属性
        println(Person.name)
    }
}