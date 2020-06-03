package com.yey.kotlin2

import org.junit.Test

class `34-泛型通配符` {
    // Kotlin中叫星号类型,Java中叫泛型通配符
    // * 泛型可以接收任何的类型,类似Java中通配符?
    fun call(arr:ArrayList<*>){

    }
    @Test
    fun 星号泛型(){
        call(ArrayList<Int>())
        call(ArrayList<Boolean>())
    }

}