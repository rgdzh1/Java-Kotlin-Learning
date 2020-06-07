package com.yey.kotlin2

import org.junit.Test

class `47-密封类` {
    // 密封类,有点像超级枚举.
    // 枚举: 每个枚举常量只有一个实例
    // 密封类:密封类的一个子类可以有多个实例
    sealed class Animal {
        class Dog(val sleep: Int) : Animal()
        class Cat(val drink: Boolean) : Animal()
    }

    @Test
    fun 密封类() {
        judge(Animal.Cat(true))
        judge(Animal.Cat(true))
        judge(Animal.Dog(100))
    }

    fun judge(animal: Animal) = when (animal) {
        is Animal.Dog -> println(animal.sleep)
        is Animal.Cat -> println(animal.drink)
        else -> println("啥都不是")
    }
}