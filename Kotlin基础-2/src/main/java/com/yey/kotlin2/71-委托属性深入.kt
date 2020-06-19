package com.yey.kotlin2

import org.junit.Test
import kotlin.reflect.KProperty

class A1 {

    var name: String by MyDelegate()
}

class A2 {
    var name: String by MyDelegate()
}

class MyDelegate {
    lateinit var name: String
    var age: String = "10"
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        val substringBefore = thisRef.toString().substringBefore('@')
        println("${substringBefore}.get()已经被调用了")
        return name
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String) {
        val substringBefore = thisRef.toString().substringBefore('@')
        println("${substringBefore}.set()已经被调用了")
        name = s
    }
}

class `71-委托属性深入` {
    @Test
    fun 属性委托() {
        val a1 = A1()
        val a2 = A2()
        a1.name = "小明"
        a2.name = "小花"
        println(a1.name)
        println(a2.name)
    }
}


inline fun <reified T> A3.de(f: () -> T): T {
    return f();
}

class A4 {
    fun myPrint() {
        println("打印数据")
    }
}

class A3 {
    val str: A4 by de {
        A4()
    }

    @Test
    fun test() {
        str.myPrint()
    }
}

private operator fun Any.getValue(a3: A3, property: KProperty<*>): A4 {
    return A4()
}





