package com.yey.gggg

interface IWashBowl {
    fun washing()
}

class BigHeadSon : IWashBowl {
    override fun washing() {
        println("大头儿子洗碗")
    }
}

// by 大头儿子代理小头爸爸洗碗了
class SmallHeadSon : IWashBowl by BigHeadSon() {
    override fun washing() {
        // 委托大头儿子洗碗, 这里就是委托了
        BigHeadSon().washing()
    }

}

fun main(args: Array<String>) {
    SmallHeadSon().washing()
}