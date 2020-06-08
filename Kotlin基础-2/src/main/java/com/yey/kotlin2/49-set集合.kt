package com.yey.kotlin2

import org.junit.Test
import java.util.*

class `49-set集合` {
    // set集合,不能存放重复的元素
    @Test
    fun 只读set集合() {
        // 这样创建的集合无法修改,只能读取.
        val set = setOf<String>("1", "2", "3")
        println(set)
    }

    @Test
    fun 可修改set集合() {
        val mutableSetOf = mutableSetOf<String>("1", "2", "3")
        mutableSetOf.add("4")
        mutableSetOf.add("4")
        mutableSetOf.add("4")
        println(mutableSetOf)
    }

    @Test
    fun java中set集合() {
        val hashSetOf = hashSetOf<String>()
        // 自动排序set集合
        val treeSet = TreeSet<String>()
        treeSet.add("z")
        treeSet.add("f")
        treeSet.add("u")
        println(treeSet)
    }

    @Test
    fun treeSet排序() {
        val treeSet = TreeSet<Person>()
        treeSet.add(Person(10))
        treeSet.add(Person(30))
        treeSet.add(Person(90))
        treeSet.add(Person(2))
        treeSet.forEach {
            println(it.age)
        }

    }

    class Person(var age: Int) : Comparable<Person> {
        override fun compareTo(other: Person): Int {
            return this.age - other.age
        }
    }
}