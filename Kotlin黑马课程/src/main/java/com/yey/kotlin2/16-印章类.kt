package com.yey.kossss2

import com.yey.km.Son

// 印章类: 子类类型有限的class,类似枚举一些类

sealed class Person {
    class 小明() : Person() {
        fun action() {
            println("小明动作")
        }
    }

    class 小红() : Person() {
        fun action() {
            println("小红动作")
        }
    }
}

fun main(args: Array<String>) {
    val 小明 = Person.小明()
    val 小红 = Person.小红()
    var mList = listOf<Person>(小明, 小红)
    for (p in mList) {
        // 类型判断
        if (p is Person.小红) {
            p.action()
        }
        if (p is Person.小明) {
            p.action()
        }
        // 类型强转
        val mPerson = p as? Person.小明
        if (mPerson != null) {
            mPerson.action()
        }
    }
}
