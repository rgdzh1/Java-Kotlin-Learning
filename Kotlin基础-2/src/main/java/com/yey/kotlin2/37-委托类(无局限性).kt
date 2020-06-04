package com.yey.kotlin2

import org.junit.Test

class `37-委托类(无局限性)` {
    interface WashPower {
        // 洗碗行为
        fun wash()
    }

    class BigHeadSon : WashPower {
        override fun wash() {
            println("大头儿子洗碗")
        }
    }

    class WeiqunMother : WashPower {
        override fun wash() {
            println("围裙妈妈有洗碗能力")
        }
    }

    // 这里将小头爸爸的洗碗能力委托给了有能力洗碗的人,传入一个有能力洗碗的wp对象,然后将洗碗能力委托给它
    class SmallHeadFather(var wp: WashPower) : WashPower by wp

    @Test
    fun 无局限性继承() {
        val weiqunMother = WeiqunMother()
        val smallHeadFather = SmallHeadFather(weiqunMother)
        smallHeadFather.wash()
        val bigHeadSon = BigHeadSon()
        val smallHeadFather1 = SmallHeadFather(bigHeadSon)
        smallHeadFather1.wash()
    }
}