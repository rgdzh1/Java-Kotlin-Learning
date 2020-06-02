package com.yey.kotlin2

import org.junit.Test
import kotlin.math.abs

class `23-继承` {
    @Test
    fun 封装() {
        // 隐藏内部实现细节
    }

    @Test
    fun 普通类继承() {
        open class Father {
            open var name = "张三"
            var age = 20
            fun eat() {
                println("父亲吃肉")
            }
        }

        // : 表示继承关系
        // 父类后面加()
        // 父类必须为open才可以被自类继承
        class Son : Father() {
            // 重写父类属性
            // 1. 子类属性前加override
            // 2. 父类属性前加open
            override var name = "张四"
            // 子类可以直接使用父类属性
        }

        val son = Son()
        son.age = 200
        println(son.age)
        println(son.name)
    }

    // 抽象类反映的是事物的本质,只能单继承
    abstract class Human {
        // 抽象类以abstract开头
        // 抽象类中可以没有抽象方法和抽象字段
        abstract var color: String;
        var language: String = ""
        abstract fun eat()
    }

    class ZHHuman(override var color: String) : Human() {
        override fun eat() {
            println("拿筷子吃")
        }
    }


    @Test
    fun 抽象类继承() {
        var zhHuman = ZHHuman("黄色")
        println(zhHuman.color)
        zhHuman.eat()
    }
}