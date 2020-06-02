package com.yey.kotlin2

import org.junit.Test

class `22-次构函数` {
    @Test
    fun 次构函数() {
        // 如果类中声明了主构造器,那么所有第二构造器都需要调用主构造器,或通过另外一个第二构造器间接调用主构造器
        class Person(var age: Int) {
            var name = ""

            // 次构函数
            constructor(age: Int, name: String) : this(age) {
                // 次构函数中,参数前无法加var,所以新的属性需要手动赋值
                this.name = name
            }
        }

        var person = Person(20, "张三")
        println(person.name)
    }

    @Test
    fun 次构函数与init执行顺序(){
        class Person(age:Int){
            init {
                println("打印init")
            }
            constructor(age:Int,name:String):this(age){
                println("打印次构函数")
            }
        }
        // 最终结果是init先执行,然后执行次构函数.
        var person = Person(10,"张三");
    }
}