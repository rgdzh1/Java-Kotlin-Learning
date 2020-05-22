package com.yey.kotlini

var m: Int = 20
var price: Double = 20.3
var flag: Boolean = true
var v1: Int = 100
var v2: Double = 20.4


var m1 = 20;
val m2: Byte = 10

var x: Long = 20
val x2: Short = 30
var x3 = 30L // Long类型
var x4 = 40f // Float类型
var x5 = 10_00_00_00 // 下划,数值分隔符
fun main(args: Array<String>) {
//    m1 = m2 无法将byte隐式转换为int
//    x = x2 无法将Short隐式转换为Long
//    m1 = x.toInt() // 通过toInt() 可以将Long类型转为Int
//    check('b')
//    charToInt('l')
//    arrayOfDemo()
//    arrayDemo()
    StringDemo()
}

var c: Char = 'a' // Kotlin中字符不允许直接比较ASCII码,只能字符与字符比较
fun check(a: Char) {
    if (a == 'a') println("相等") else println("不相等")
}

/**
 * 字符可以转换为Int值
 */
fun charToInt(a: Char) {
    println(a.toInt())
}
/**
 * Kotlin转义符
 * \t 制表符
 * \b 退格符
 * \n 换行符
 * \r 回车符
 * \' 单引号
 * \" 双引号
 * \\ 反斜杠
 */

// 数组
/**
 * 使用arrayOf()函数定义可以存储任意值的数组
 */

fun arrayOfDemo() {
    val array = arrayOf(1, '3', true, false, 100)
    println(array[0])
    println(array[1])
    println(array[2])
    println(array[3])
    println(array[4])
    array[4] = 'c'
    println(array[4])
}

/**
 * 使用arrayOfNulls()函数定义指定长度的空数组
 */
val array = arrayOfNulls<String>(10)

/**
 * 使用Array 类的构造器定义数组,数组元素的值就是最后一行语句了
 */
fun arrayDemo1() {
    val array = Array(10, { i: Int ->
        println(i)
        i * 10 // 这个i 就是数组中的元素了
    })
    println(array[1])
    println(array[2])
}

/**
 * 使用intArrayOf函数定义数组
 */
fun arrayDemo() {
    val array = intArrayOf(10, 20)
    println(array[1])
}
// 字符串
// 普通字符串,类似Java,双引号表示,可以用转义符
// 保留原始格式字符串,无法使用转义符,使用三引号.

fun StringDemo1() {
    // 普通字符串
    var s1 = "Hello \n World"
    println(s1)
    // 保留原有格式字符串
    var s2 = """hello 
        |Wor
        |l
        |d
        |You
    """.trimMargin()
    println(s2)
}

// 字符串模板
// ${可以调用API}
fun StringDemo() {
    val s = 10
    var s1 = "s = $s"
    println(s1)
    var s3 = "xdkafslkjlfsadkf;lsd"
    var s4 = "s3长度${s3.length}"
    println(s4)
}
