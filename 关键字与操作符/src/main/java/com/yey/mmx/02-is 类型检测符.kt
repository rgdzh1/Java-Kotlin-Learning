package com.yey.mmx

import org.junit.Test

class `02-is 类型检测符` {
    @Test
    fun test() {
        var ttt = "s2"
        var ttt1 = null
        if (ttt is String) {
            println(ttt.length)
        }
        if (ttt !is String) {
            println("Not a String")
        } else {
            println(ttt.length)
        }
        if (ttt1 is Int) {
            println(ttt1)
        }
        if (ttt1 is Long) {
            println(ttt1)
        }
    }
}