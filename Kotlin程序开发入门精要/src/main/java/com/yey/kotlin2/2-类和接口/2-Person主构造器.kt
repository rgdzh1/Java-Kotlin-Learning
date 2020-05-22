package com.yey.kots

//class Person constructor(name: String) {
// constructor(name: String) 主构造器,是类头的一部分

//}

class `2-Person主构造器`(name: String) {
    // constructor关键字其实可以省略
    var mName = name // 主构造器参数可以用在对类的属性初始化

    init {
        print(name) // 主构造器参数可以用在init块中
    }
}