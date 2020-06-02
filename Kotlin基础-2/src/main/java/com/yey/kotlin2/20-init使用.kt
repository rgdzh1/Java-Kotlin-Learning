package com.yey.kotlin2

import org.junit.Test

class `20-init使用` {
    class Person(age: Int, name: String) {
        var age = 0;
        var name = ""

        // 写Java时,一般在构造函数中给属性赋值,但是Kotlin没有构造函数,所以赋值的任务就放在init{}中处理.
        init {
            this.age = age
            this.name = name
        }
    }

    @Test
    fun init方法的作用() {
        var person = Person(20, "张三")
        println(person.age)
        println(person.name)
    }
}