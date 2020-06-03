package com.yey.kotlin2

import org.junit.Test

class `27-is操作符` {
    open class Animal
    class Cat : Animal() {
        fun eat() {
            println("吃饭")
        }
    }

    class Dog : Animal() {
        fun sleep() {
            println("睡觉")
        }
    }

    @Test
    fun is操作符(){
        // 使用父类接收之后,如何单独调用每个子类特有的方法呢
        val dog:Animal = Dog()
        val cat:Animal = Cat()
        if (dog is Dog){
            // 通过is操作符就可以自动判断对象的类型,然后就可以直接调用对象中的方法了.不需要使用显示转换符了
            // val dog1 = dog as Dog 这种显示的强转已经没有必要了
            dog.sleep()
        }
        if (cat is Cat){
            cat.eat()
        }

    }
}