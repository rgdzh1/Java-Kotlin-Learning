package com.yey.kotlin2

import org.junit.Test

// 通过父类接收,执行子类方法
class `26-多态` {
    abstract class Animal {
        abstract fun call()
        open fun sleep() {
            println("动物睡觉")
        }
    }

    class Dog : Animal() {
        override fun call() {
            println("狗叫")
        }

        override fun sleep() {
            println("狗睡觉")
        }
    }

    class Cat : Animal() {
        override fun call() {
            println("猫叫")
        }
    }

    @Test
    fun 多态(){
        // 通过父类接收对象,调用子类方法
        var cat:Animal = Cat()
        var dog:Animal = Dog()
        // 类似Java中多态
        cat.call() // 虽然类型是父类,但是调用的还是子类本身的方法
        cat.sleep()// 子类方法重写之后调用的是子类的方法,不会调用父类的方法
        dog.call()
        dog.sleep()
    }
}