package com.yey.kotkk

val mName = "小明"
fun main(args: Array<String>) {
    add(age = 10)
}

// name: String = mName 当调用者不传递name参数时候,就使用默认的name="小明"
// add(age = 10) 如果不传入name参数那单独传入age参数时候就必须写特定的名称
fun add(name: String = mName, age: Int) {
    println("名字: $name 年龄: $age")
}

