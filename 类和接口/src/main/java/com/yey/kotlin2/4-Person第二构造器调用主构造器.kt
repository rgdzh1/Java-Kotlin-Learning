package com.yey.kotlin2

// 如果类中声明了主构造器,那么所有第二构造器都需要调用主构造器,或通过另外一个第二构造器间接调用主构造器
class `4-Person第二构造器调用主构造器`(age: Int) {

    // 已经声明了主构造器,第二构造器必须要调用主构造器
    constructor(name: String) : this(20) {
        println("我的名字叫$name")
    }

    constructor(eat: Boolean) : this("张三") {
        println("吃饭了么$eat")
    }
}