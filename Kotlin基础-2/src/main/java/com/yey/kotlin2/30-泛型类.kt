package com.yey.kotlin2
// Kotlin泛型和Java泛型太相似了
class `30-泛型类` {
    // 泛型: 在强类型程序设计语言中编写代码时定义一些可变的部分

    // 水杯抽象类
    abstract class Cup

    // Box是一个抽象类,定义了泛型T,其中属性things的类型由创建时指定的泛型提供
    abstract class Box<T>(var things: T)

    // 创建一个装杯子的盒子,该盒子的泛型为明确指定的Cup类型
    class CupBox(things: Cup) : Box<Cup>(things)

    // 创建一个水果盒子,但是这个盒子没有预先指定泛型,
    // 当盒子创建时指定泛型
    class FruitBox<T>(things: T) : Box<T>(things)
}