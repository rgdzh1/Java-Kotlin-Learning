package com.yey.kotlin2

import org.junit.Test

// 惰性加载条件
// 1 字段val 不可变值
// 2 by lazy 可以放到成员变量中,也可以单独存在
// 3. by lazy的返回值就是最后一行
// 4. 惰性加载是线程安全的.
val 惰性加载 :Int by lazy {
    println("by lazy 加载了几次")
    10
}
class `39-by lazy惰性加载` {
    @Test
    fun 惰性加载(){
        // 惰性加载,当用到的时候才会加载到内存中,只加载一次
        println(惰性加载)
        println(惰性加载)
        println(惰性加载)
        println(惰性加载)
    }
}