package com.yey.kotl

import java.util.*

fun main(args: Array<String>) {
    var list = listOf<String>("萝卜", "白菜", "大米")
    for ((i, v) in list.withIndex()) {
        println("索引$i 值$v")
    }
    var map = TreeMap<String, String>()
    map["好"] = "good"
    map["学习"] = "study"
    map["天"] = "day"
    map["向上"] = "up"
    for (item in map) {
        println("键:${item.key} = 值:${item.value}")
    }
}
