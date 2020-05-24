package com.yey.kotlin2

fun main(args: Array<String>) {
    var str = "   张 三 "
    //println(str.trim())// 删除首尾两端字符
    // 原样输出字符
    var str1 = """
        今天
        是
        星期天
    """
    println(str1) // 这样输出前面是有缩进的
    var str2 = """
        今天
        是
        星期天
    """.trimIndent()// trimIndent() 就是删除前面的缩进
    println(str2)

    var str3 = """
        /今/天
        /是
        /星期天/
    """.trimMargin("/")// trimMargin("/") 匹配到字符前端有"/"将删除"/"
    println(str3)
}