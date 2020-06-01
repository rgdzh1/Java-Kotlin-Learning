package com.yey.kotlin2

import org.junit.Test

class `05-空值处理` {

    @Test
    fun test() {
        // 类型默认标记为非空
        // var str: String = null 赋值空值会编译报错
        // (?) 将类型标记为可空
        var str1: String? = null

        // 第一:由于str1被标记为可空
        // 第二:toInt() API只能非空类型对象调用,如果str1为可空类型,则不允许调用.
        // str1.toInt() 编译失败

        // 解决办法:
        // (!!) 非空断言运算符,如果str1为空,则会抛出异常.
        // 编译时关闭空检查
        // str1!!.toInt() 编译通过,但运行可能会报错.

        // (?.) 安全调用符,如果str1不为空才会调用toInt() API
        str1?.toInt()
        // 类似与
        if (str1 != null) {
            str1.toInt()
        }


        // str2标记为可空类型
        var str2: String? = null
        // 由于strToInt默认标记非空类型,而(str2?.toInt())返回值可能为空,所以编译报错
        // var strToInt: Int = str2?.toInt(); 编译失败
        // 解决办法
        // 将strToInt标记为可空
        // var strToInt: Int? = str2?.toInt();
        // 假如strToInt必不能为空该如何处理?
        // (?:) elvis操作符,如果左侧(str2?.toInt())为空值,就取右侧值(0)
        var strToInt: Int = str2?.toInt() ?: 0;
        println(strToInt)
    }
}