package com.yey.koxxx


interface IWashBowl {
    fun washing()
}

// object 代表的是单例
object BigHeadSon : IWashBowl {
    override fun washing() {
        println("大头儿子洗碗")
    }
}

fun main(args: Array<String>) {
    BigHeadSon.washing()
}