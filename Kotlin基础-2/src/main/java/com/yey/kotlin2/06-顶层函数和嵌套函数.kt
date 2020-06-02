package com.yey.kotlin2

import org.junit.Test

/**
 * 函数式编程中, 函数是一等公民,函数可以独立于对象存在.
 * main(args: Array<String>):它是顶层函数
 */
fun main(args: Array<String>) {
    shopping()
}

/**
 * 顶层函数
 */
fun pay() {
}

fun shopping() {
    /**
     * select():嵌套函数
     */
    fun select() {
        println("嵌套函数")
    }
    // 执行嵌套函数
    select()
}