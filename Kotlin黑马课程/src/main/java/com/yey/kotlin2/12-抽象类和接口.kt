package com.yey.kotlin2

// 接口泛指实体把自己提供给外界的一种抽象化物,用以由内部操作分离出外部沟通的方法
// 使其能够被内部修改而不影响外界其他实体与其交互的方式
// 接口是事务的能力, 抽象类是事务的本质
interface IMan {
    fun 吃饭()
}

interface 喝水 {
    fun 喝水()
}

interface IWoman {
    fun 吃饭()
}

// 如果是继承抽象类, 父类需要一个小括号
open class Man : IMan {
    override fun 吃饭() {
        println("吃得多")
    }
}

// 小明类继承自Man类,实现了喝水接口
class 小明 : Man(), 喝水 {
    override fun 喝水() {
        println("小明能喝水了")
    }
}

fun main(args: Array<String>) {
    val 小明 = 小明()
    小明.吃饭()
    小明.喝水()
}

