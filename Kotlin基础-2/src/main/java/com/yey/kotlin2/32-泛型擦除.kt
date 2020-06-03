package com.yey.kotlin2

import org.junit.Test

class `32-泛型擦除` {

    @Test
    fun 泛型擦除() {
        parseType(10)
        var arr1: Array<Int>? = Array<Int>(0) {
            0
        }
        var arr2: Array<String>? = Array(0) {
            ""
        }
        // if (arr1 is Array<String>) 编译报错，和Java一样，Kotlin运行时不保留泛型，及对象不携带传递到他们构造器中的那些类型参数的实际类型，
        // Array<Int>(0)与Array<String>(0)是没法区别的
        arr1 is Array<*> // 这样判断是可以的，但是不保证列表内容

    }

    inline fun <reified T> parseType(t: T) {
        // 这里是无法通过参数t来获取泛型的
        // t!!::class.java.name 会导致程序无法编译通过

        // 一般写法（inline fun <reified T>），通过泛型 T::class.java.name 直接获取类型会出现编译报错
        // inline fun <reified T> 这样写就可以使用泛型获取到当前参数的类型
        val name = T::class.java.name
        println("通过泛型获取参数类型: $name")
    }
}