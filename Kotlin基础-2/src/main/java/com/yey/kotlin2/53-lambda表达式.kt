package com.yey.kotlin2

import org.junit.Test

class `53-lambda表达式` {
    /***
     * (Int,Int)->Int: 这个类型是函数类型其中(Int,Int)为参数类型,->Int为该函数的返回值类型,
     * 函数类型的参数需要接收该函数的地址值.
     */
    fun cacl(a: Int, b: Int, tool: (Int, Int) -> Int): Int {
//        return util(a, b)
        return tool.invoke(a, b)//invoke()就是调用方法
    }

    /**
     * 在Kotlin中匿名函数的别名就是lambda表达式
     */
    @Test
    fun lambda表达式() {
        // {m,n->m+n} : 这个就是匿名函数,上面的cacl()方法中最后一个参数的类型是函数类型,匿名函数直接就能被cacl中最后一个参数tool接收.
        println(cacl(10, 20, { m, n -> m + n }))
    }

    // 看看这个lambda表达式
    fun myFun(f: () -> Unit) {
        f()
    }

    @Test
    fun lambda表达式优化写法() {
        // 如果函数中最后一个参数是函数类型, 那么lambda表达式可以移动到括号以外的地方
        cacl(10, 200) { m, n ->
            // lambda表达式中最后一行就是返回值
            m + n
        }
        // 如果函数中最后一个参数是函数类型,那么lambda表达式可以移动到括号以外的地方,如果括号中没有参数,那么这个括号可以去除.
        // 第一种写法
        myFun({
            println("第一种写法")
        })
        // 第二种写法
        myFun() {
            println("第二种写法")
        }
        // 第三种写法
        myFun {
            println("第三种写法")
        }
    }

    @Test
    fun 嵌套匿名函数() {
//        {
//            println("执行匿名函数")
//        }()
        // invoke的好处就是可以用?. 安全调用符号
        {
            println("执行匿名函数方法2")
        }?.invoke()
    }

    @Test
    fun 嵌套匿名有参lambda表达式() {
        // 第一种有参lambda表达式
//        val result = { a: Int, b: Int ->
//            a + b
//        }(10, 20)
//        println(result)
        // 第二种
        // invoke() 调用,好处是可以使用安全符号调用
        val invoke = { a: Int, b: Int -> a + b }?.invoke(10, 20)
        println(invoke)
    }

    @Test
    fun 嵌套匿名lambda表达式如何保存() {
        // 使用myFun变量保存lambda表达式
        val myFun: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
        // 调用保存的lambda表达式
        myFun(20, 30)
        // invoke 就是可以加安全调用符号
        myFun.invoke(10, 30)

    }

    @Test
    fun lambda表达式一个参数省略it() {
        println(tool(10) {
            100 + 10
        })
    }

    // 参数f是函数类型,f的参数只有一个,如果f是一个lambda表达式,那么第一个参数就可以忽略不写,然后用it代替
    fun tool(a: Int, f: (Int) -> Int) {
        f(a)
    }

    @Test
    fun lambda表达式的返回值() {
        val function = {
            // 在lambda表达式中,大括号的最后一行代表的就是返回值,
            println("返回值")
            10
            "10"
        }()
    }

    @Test
    fun 查看Kotlin中的lambda表达式(){
        // 阅读下forEach lambda表达
        // 1. CharSequence.forEach() 代表的是对字符串的扩展函数
        // 2. action: (Char) -> Unit 表示forEach中接收的是一个函数类型的参数
        // 3. for (element in this) this代表字符串本身,对字符串进行遍历
        // 4. 美遍历到一个元素都会调用传入的lanmbda函数.
//        public inline fun CharSequence.forEach(action: (Char) -> Unit): Unit {
//            for (element in this) action(element)
//        }
        var str = "abcms"
        // forEach中接收的函数参数,action: (Char) -> Unit,然后看看println整好符合这个类型,所以println()方法其实适合当作参数传入forEach中
        str.forEach(::println)
    }

    @Test
    fun 查看indexOffFirst(){
        val arrayOf = arrayOf("林大瞎", "风大","林大傻")
        // 1. Array<out T>.indexOfFirst : indexOfFirst是Array的扩展函数
        // 2. indexOfFirst(predicate: (T) -> Boolean) 接收的参数类型是方法类型,该lambda表达式接收一个泛型参数,
        // 3. indices 为Array的长度
        // 4. 遍历Array长度,取出不同的值,然后传入lambda表达式中
        // 5. 如果lanmbda表达式返回的是true,则indexOfFirst返回当前索引,如果lambda表达式为false,就indexOfFirst返回-1
//        public inline fun <T> Array<out T>.indexOfFirst(predicate: (T) -> Boolean): Int {
//            for (index in indices) {
//                if (predicate(this[index])) {
//                    return index
//                }
//            }
//            return -1
//        }
        val indexOfFirst = arrayOf.indexOfFirst {
            it.startsWith("林")
        }
        println(arrayOf[indexOfFirst])
    }
}