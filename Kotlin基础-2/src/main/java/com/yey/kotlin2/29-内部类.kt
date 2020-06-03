package com.yey.kotlin2

import org.junit.Test

class `29-内部类` {
    class OutClass {
        var name: String = "李四"

        // InnerClass是内部类,只要在前面加上inner就可以了.
        // 内部类是可以访问外部类数据的
        inner class InnerClass {
            fun myPrint() {
                println("打印外部类属性 $name")
            }
        }
    }

    @Test
    fun 内部类创建() {
        val innerClass = OutClass().InnerClass()
        innerClass.myPrint()
    }
}