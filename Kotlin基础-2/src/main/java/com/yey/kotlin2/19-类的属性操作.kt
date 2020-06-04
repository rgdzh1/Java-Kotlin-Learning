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

    class Kid {
        var name = "本本"
            set(value) {
                // this.name = value 看似使用等于号赋值,实则调用了name属性的set方法,
                // 这样坑就来了,最终会造成递归调用,最后导致内存溢出.
                // this.name = value
                // 所以,就有了field字段,它代表的就是name属性
                // set()方法在哪个属性下方,field就代表该属性.
                field = value
            }
        var age = 1
            set(value) {
                if (value < 2) {
                    println("age 不符合要求")
                } else {
                    // 此时field代表age属性
                    field = value
                }
            }
            // 重写属性get()
            // 他最后也不能使用return age, 不然也和上面说的那样造成了递归调用了.
            get() {
                return field
                // return 10
            }
    }

    @Test
    fun 修改set与get方法() {
        val k = Kid()
        k.age = 18
        println(k.age)
        println(k.name)
    }
}