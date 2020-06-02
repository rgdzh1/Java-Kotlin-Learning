package com.yey.kotlin2

import org.junit.Test

class `21-去除init赋值简化操作` {
    @Test
    fun 简单方法给属性赋值() {
        class Person(age: Int, name: String)

        var person = Person(10, "张三")
        // person.age 编译出错,此时无法使用age

        // 解决办法.在参数前加val或者var就能自动为属性赋值了.
        class Person1(var age: Int, val name: String)
        var person1 = Person1(10,"张三")
        person1.age = 20
        // person1.name="李四" 编译报错,因为name使用val标记,只能取不能写.
        println(person1.age)
        println(person1.name)

    }
}