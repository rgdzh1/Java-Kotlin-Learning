package com.yey.kotlin2

import org.junit.Test

class `24-接口` {
    open class Person()
    interface Eat {
        fun eat()
    }

    interface Sleep {
        var sleepTime: String // 接口中字段无需赋值
        fun sleep()
    }

    interface Drink {
        // 接口中方法是可以实现的,也可以被继承
        fun drink() {
            println("人必须喝水")
        }
    }

    // 类代表事物本质,单继承
    // 接口代表事物能力,可以多实现.
    class Childe : Person(), Eat, Sleep, Drink {
        // 子类实现接口,必须实现接口中字段
        override var sleepTime: String = "10小时"

        override fun eat() {
            println("吃饭")
        }

        override fun sleep() {
            println("睡觉")
        }
    }

    @Test
    fun 单继承与多实现() {
        val childe = Childe()
        childe.eat()
        childe.sleep()
    }

    @Test
    fun 接口中字段() {
        val childe = Childe()
        println(childe.sleepTime)
    }

    @Test
    fun 接口中方法() {
        val childe = Childe()
        childe.drink()
    }
}