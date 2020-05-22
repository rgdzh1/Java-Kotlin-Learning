package com.yey.kotlin33


class Customer {
    // 只读属性
    val name: String
        get() = "哈哈"

    var age: Int = 20


    // 读写属性
    var price: Int
        set(value) {
            price = value
        }
        get() = price


    // field 标识符
    var sex: String = "男"
        get() = field //从field中读取属性值
        set(value) {
            field = value
        }

    init {
        this.price = 10
    }
}

fun main(args: Array<String>) {
    val customer = Customer()
    println(customer.name)
    customer.age = 10
    println(customer.age)
    customer.price = 15
    println(customer.price)
    customer.sex = "女"
    println(customer.sex)

}