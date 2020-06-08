package com.yey.kotlin2

import org.junit.Test

class `48-List集合` {
    @Test
    fun 只读集合(){
        val listOf = listOf<String>("1", "2", "3")
        listOf.forEach {
            println(it)
        }
//        listOf[0]="30"编译出错,无法修改该集合
    }
    @Test
    fun 可修改集合(){
        val mutableListOf = mutableListOf<String>("妈妈", "爸爸", "孩子")
        // 修改索引0的元素为某值
        mutableListOf.set(0,"孩子")
        // 在索引1处增加元素
        mutableListOf.add(1,"妹妹")
        println(mutableListOf)
    }
    @Test
    fun 调用Java集合(){
        val arrayListOf = arrayListOf<String>("妈妈", "爸爸", "孩子")
        val arrayList = ArrayList<String>()
    }
}