package com.yey.kbb

// 多态: 同种功能不同表现形态
abstract class Human(var name: String) {
    abstract fun action()
}

class Woman(var mName: String) : Human(mName) {
    override fun action() {
        println("打伞")
    }
}

class Man(var mName: String) : Human(mName) {
    override fun action() {
        println("不打伞")
    }
}

fun main(args: Array<String>) {
    val woman = Woman("小红")
    val man = Man("小华")
    var list = listOf<Human>(woman, man)
    for (m in list) {
        println(m.action())
    }
}


