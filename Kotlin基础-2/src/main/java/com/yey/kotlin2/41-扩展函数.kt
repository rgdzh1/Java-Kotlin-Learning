package com.yey.kotlin2

import org.junit.Test

class `41-扩展函数` {
    // 扩展类格式
    // fun 对象类型.方法名称() 返回值类型
    @Test
    fun 扩展函数() {
        var str = null
        val jugeEmpty = str.jugeEmpty()
        println(jugeEmpty)
    }

    //对String进行扩展
    // ? 表示安全调用符号
    fun String?.jugeEmpty(): Boolean {
        // 扩展函数可以方法对象中的方法,属性等.
        return this == null || this.length == 0
    }

    // ========================================
    open class Person
    class Children : Person()

    // 父类定义扩展函数
    fun Person.eat() {
        println("开始吃饭")
    }

    @Test
    fun 扩展函数继承() {
        // 创建子类对象调用父类扩展方法
        val children = Children()
        children.eat()
    }

}