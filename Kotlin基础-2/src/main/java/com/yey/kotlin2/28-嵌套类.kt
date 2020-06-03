package com.yey.kotlin2

import org.junit.Test

class `28-嵌套类` {
    class OutClass {
        var name = "张三"
        class NestedClass {
            // 转化为Java代码可以看到NestedClass是属于静态类
            fun myPrint(){
                // println("打印外部类属性 $name") 嵌套类NestedClass是无法访问外部类,和外部类没有任何关系.
            }
        }
    }
    @Test
    fun 嵌套类(){
        // 创建嵌套类对象,嵌套类是属于静态的与外部类无关,他们之间的数据是无法相通的
        val nestedClass = OutClass.NestedClass()
    }

}