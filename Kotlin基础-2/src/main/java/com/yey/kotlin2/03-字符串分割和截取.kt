package com.yey.kotlin2

fun main(args: Array<String>) {
    var str = "张三.李四-王五"
    // java中分割得到数组,Kotlin得到的是集合
    // 多条件分割, Kotlin中这个API比Java中强大
    val list = str.split(".", "-")
    println(list)
    //-----字符串截取-----
    val path = "/Users/yole/kotlin-book/chapter.adoc"
    // 获取前6个字符
    println(path.substring(0, 6))//左闭右开
    println(path.substring(0..5))//获取0-5区间
    // 把第一个r之前的字符截取
    println(path.substringBefore('r'))
    // 把第一个r之后的字符截取
    println(path.substringAfter('r'))
    // 把最后一个r之前的字符截取
    println(path.substringBeforeLast('r'))
    //把最后一个r之后的字符截取
    println(path.substringAfterLast('r'))

}
