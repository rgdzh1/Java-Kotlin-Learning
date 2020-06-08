package com.yey.kotlin2

import org.junit.Test
import java.util.*

class `50-Map集合` {
    @Test
    fun 只读Map() {
        val mapOf = mapOf<String, String>("中国" to "China", "英国" to "England", "美国" to "USA")
//        mapOf["中国"] = "美国"编译报错,不能修改
        mapOf.forEach { s, s2 -> println("英文名称$s2 中文名称$s") }
    }

    @Test
    fun 可变Map() {
        val mutableMapOf = mutableMapOf<String, String>()
        mutableMapOf.set("中国", "China")
        mutableMapOf.set("英国", "England")
        mutableMapOf.set("美国", "USA")
        // 遍历map集合
        mutableMapOf.forEach { s, s2 -> println("英文名称$s2 中文名称$s") }
        mutableMapOf["中国"] = "6666"
        mutableMapOf.forEach { s, s2 -> println("英文名称$s2 中文名称$s") }
        // 访问map集合
        println(mutableMapOf["中国"])
        // 修改map
        mutableMapOf["中国"] = "666"
        println(mutableMapOf["中国"])

    }

    @Test
    fun java中Map集合() {
        val hashMapOf = hashMapOf<String, String>()
        val hashtable = Hashtable<String, String>()
        hashtable.set("中国", "China")
        hashtable.set("英国", "England")
        hashtable.set("美国", "USA")
        // 访问map
        println(hashMapOf["美国"])
        // 修改map
        hashMapOf["美国"] = "美元"
        println(hashMapOf["美国"])
    }

    @Test
    fun map集合遍历() {
        val mutableMapOf = mutableMapOf<String, String>()
        mutableMapOf.set("中国", "China")
        mutableMapOf.set("英国", "England")
        mutableMapOf.set("美国", "USA")
        // 遍历keys
        val keys = mutableMapOf.keys
        keys.forEach {
            println(it)
        }
        // 遍历values
        mutableMapOf.values.forEach { println(it) }
        // 遍历键值对
        val entries = mutableMapOf.entries
        entries.forEach {
            println(it.key + " " + it.value)
        }
        // for遍历
        for ((key, value) in mutableMapOf) {
            println(key + " " + value)
        }
    }
}