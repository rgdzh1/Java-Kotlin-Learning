package com.yey.kotlin2

import org.junit.Test

class `46-data数据类` {
    // 定义一个数据类型,在class前面加data
    data class News(var title: String, var desc: String, var imgePath: String, var content: String)

    @Test
    fun 结构() {
        // 结构,这样就能拿到所有的属性值了,简洁方便
        val (title, desc, imgePath, content) =News("标题","简介","路径","内容")
        println(title)
        println(desc)
        println(imgePath)
        println(content)
    }
}