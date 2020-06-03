package com.yey.kotlin2

import org.junit.Test

class `33-泛型类型投射` {
    open class Person
    open class Student : Person()
    class ChildSudent : Student()

    @Test
    fun 泛型类型投射() {
        matchStudent(ArrayList<Person>())
        // 这个和Java中很像,虽然ArrayList<Student>()与ArrayList<Person>()都是虽然ArrayList类型,但是两个是不同的东西.
//        matchStudent(ArrayList<Student>())
//        matchStudent(ArrayList<ChildSudent>())
    }

    fun matchStudent(persons: ArrayList<Person>) {

    }

    @Test
    fun 泛型类型投射1() {
//        matchStudent1(ArrayList<Person>())
        matchStudent1(ArrayList<Student>())
        matchStudent1(ArrayList<ChildSudent>())
    }

    // out 接收当前类型或者他的子类,类似与Java中的? extends 父类
    // 如果超过了Student类上限,就会编译不通过,很像Java中的泛型上限
    fun matchStudent1(persons: ArrayList<out Student>) {

    }

    @Test
    fun 泛型类型投射2() {
        matchStudent2(ArrayList<Person>())
        matchStudent2(ArrayList<Student>())
//        matchStudent2(ArrayList<ChildSudent>())
    }
    // in 接收当前类型或者他的父类,类似Java中的? super 父类
    // 如果是Student的子类,就会编译不通过,很像Java中的泛型下限.
    fun matchStudent2(persons: ArrayList<in Student>) {

    }
}