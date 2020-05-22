package com.yey.km

// 封装: 隐藏内部实现细节
// 继承: 一个对象直接使用另一个对象的属性和方法

fun main(args: Array<String>) {
    val son = Son()
    println(son.character)
    son.action()
}

// 父类允许被继承需要open
open class Father {
    var character = "内向"

    // 方法允许被重写需要open
    open fun action() {
        println("吃饭")
    }
}

class Son : Father() {
    // 重写父类方法需要加override, 父类中的方法需要open
    override fun action() {
        println("喝水")
    }
}