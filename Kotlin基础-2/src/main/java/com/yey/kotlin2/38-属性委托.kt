package com.yey.kotlin2

import org.junit.Test
import kotlin.reflect.KProperty

class `38-属性委托` {
    class BigHeadSon {
        var 压岁钱: Int by Mother()

    }

    class Mother {
        // 儿子之前存在妈妈这里的钱有1W
        var 儿子的压岁钱 = 1
        operator fun getValue(bigHeadSon: BigHeadSon, property: KProperty<*>): Int {
            return 儿子的压岁钱
        }

        /**
         * 参数i 就是儿子的压岁钱属性
         */
        operator fun setValue(bigHeadSon: BigHeadSon, property: KProperty<*>, i: Int) {
            // 将儿子的压岁钱保管起来
            儿子的压岁钱 += i
        }
    }

    @Test
    fun 属性委托() {
        val bigHeadSon = BigHeadSon()
        // 这一步就会调用到Mother.setValue()方法
        bigHeadSon.压岁钱 = 10
        // 儿子最后看压岁钱有多少
        println(bigHeadSon.压岁钱)
    }

    inline fun <reified T> membersOf() = T::class.java.name

    @Test
    fun aaa() {

        println(membersOf<String>())
    }
}

