package com.yey.kotlin2

import org.junit.Test

class `36-委托类(局限性强)` {
    interface WashPower{
        // 洗碗行为
        fun wash()
    }
    class BigHeadSon:WashPower {
        override fun wash() {
            println("大头儿子洗碗")
        }
    }
    // 最终小头爸爸的洗碗行为交给大头儿子去做了
    // 不过这样局限性比较的大,因为这样小头爸爸洗碗行为只能委托给大头儿子,如果想委托给其他人是不行的.
    class SmallHeadFather:WashPower by BigHeadSon()

    @Test
    fun 委托类(){
        val smallHeadFather = SmallHeadFather()
        smallHeadFather.wash()
    }
}