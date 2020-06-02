package com.yey.kotlin2

import kotlin.math.acos

fun main(args: Array<String>) {
    val str = "123456"
    for ((index, c) in str.withIndex()) {
        println("下标:$index,值:$c")
    }

    str.forEach {
        println(it)
    }


    str.forEachIndexed { index, c -> println("下标:$index,值:$c") }
}