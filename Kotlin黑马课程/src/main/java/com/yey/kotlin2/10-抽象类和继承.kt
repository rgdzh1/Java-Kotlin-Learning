package com.yey.klll


abstract class Human(var name: String) {
    abstract fun eat();
}

class Man(name: String) : Human(name) {
    override fun eat() {
        println("男人大口吃东西")
    }
}

class Woman(name: String) : Human(name) {
    override fun eat() {
        println("女人小口吃东西")
    }
}

fun main(args: Array<String>) {
    val man = Man("小明")
    println(man.name)
    man.eat()
    val woman = Woman("小红")
    println(woman.name)
    woman.eat()
}

