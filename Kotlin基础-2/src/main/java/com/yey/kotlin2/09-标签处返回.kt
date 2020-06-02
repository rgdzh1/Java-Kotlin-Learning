package com.yey.kotlin2
// 多重循环下,标签处返回可能用的上
fun main(args: Array<String>) {
    val str1 = "123"
    val str2 = "abc"
    tag@for (s1 in str1) {
        tag@for (s2 in str2) {
            if (s1 == '2') {
                // 使用break只能跳出第二层循环,但是第一层循环还在继续
                // break

                // 在第一层for循环打tag,在break后使用tag跳出循环
                break@tag
            }
            println("$s1$s2")
        }
    }
}