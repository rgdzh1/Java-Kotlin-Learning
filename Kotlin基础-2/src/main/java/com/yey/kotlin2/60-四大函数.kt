package com.yey.kotlin2

import org.junit.Test
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class `60-四大函数` {
    // apply函数本质是一个扩展函数
    // apply函数就是用来处理大范围的空值处理的
    @Test
    fun apply函数() {
        // 假如resultList标记为可空集合
        val resultList: ArrayList<String>? = arrayListOf<String>("张", "李", "王")
        // 如果再向该集合添加元素,那么每次都得加一个安全调用符号,非常麻烦
        resultList?.add("孙")
        resultList?.add("武")
        resultList?.add("田")
        // block: T.() -> Unit : 这里表示的是该方法必须是泛型T类型中特有的方法
//        public inline fun <T> T.apply(block: T.() -> Unit): T {
//            contract {
//                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//            }
//            block()
//            return this
//        }
        // 这样来处理就会节省大量的安全调用符号, 用起来很方便.
        resultList?.apply {
            add("立")
            add("胡")
            add("钱")
        }
        println(resultList)
    }

    // let函数本质是一个扩展函数
    // 返回值是lambda表达式的返回值
    // lambda表达式接收的参数为当前let函数的调用者
    // 它也可以处理大量空置调用
    @Test
    fun let函数() {
        // 假如resultList标记为可空集合
        val resultList: ArrayList<String>? = arrayListOf<String>("张", "李", "王")
        resultList?.let {
            it.add("立")
            it.add("胡")
            it.add("钱")
            "哈哈"//let函数的返回值为lambda函数的返回值
        }
        println(resultList)
    }

    // with函数是独立的函数,随时可以调用
    @Test
    fun with函数() {
        val resultList: ArrayList<String> = arrayListOf<String>("张", "李", "王")
        with(resultList) {
            this.add("钱")
            "返回值"// with函数的返回值为lambda函数的返回值
        }
        println(resultList)
    }
    // 任意函数都有可调用run函数
    @Test
    fun run函数() {
        val resultList: ArrayList<String> = arrayListOf<String>("张", "李", "王")
        resultList.run {
            this.add("钱")
            "返回值"
        }
    }
}