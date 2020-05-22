package com.yey.kotlin2i

import java.math.BigInteger

fun main(args: Array<String>) {
    var result = 阶乘(BigInteger("100"))
    println(result)
}

fun 阶乘(i: BigInteger): BigInteger {
    if (i == BigInteger.ONE) {
        return BigInteger.ONE
    } else {
        return i * 阶乘(i - BigInteger.ONE)
    }
}

