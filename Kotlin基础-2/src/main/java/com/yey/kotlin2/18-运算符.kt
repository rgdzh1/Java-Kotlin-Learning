package com.yey.kotlin2

import org.junit.Test

class `18-运算符` {
    // Kotlin中每一个运算符对应都是一个方法,运算符相当于方法的简写
    class Person {
        var age = 20
        // 对象重写运算符
        // 1. 找到运算符对应的方法
        // 2. 重写方法前加operator
        operator fun plus(age: Int): Person {
            this.age = this.age + age
            return this
        }
    }

    @Test
    fun 运算符重载() {
        val person = Person()
        // Person类中,重载了+号运算符,
        // 所以person + 10就是person.plus(10)
        // 这个就是运算符重载
        val person1 = person + 10
        println(person1.age)
    }
}
