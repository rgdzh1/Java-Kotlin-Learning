package com.yey.xiecheng

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Test

class `02-协程挂起` {
    /**
     * 协程是什么?
     * 协程就是launch()中的代码
     */
    /**
     * 挂起是什么?
     * 协程(launch()中代码)从当前执行的线程上脱离了,
     * 也可以这样说,当前线程A运行到协程代码时不再向下执行,然后当前线程A该作什么去就做什么去,如果线程A是后台线程可能就被回收到线程池了.
     * 那协程(launch()中代码)的代码现在就由挂起函数里指定的线程来执行了,然后协程执行完后会下面的代码又会切换到线程A让线程A继续执行.
     */
    /**
     * suspend关键字的作用?
     * 提醒调用者(用户)该方法耗时,需要在协程里面调用该函数.
     */
    /**
     * withContext()的作用?
     * 真正让协程被挂起的是withContext()中的一行代码.
     */

    @Test
    suspend fun 协程是什么() {
        coroutineScope {

            launch(Dispatchers.Main) {
                // 这个就是协程
                //***************
                var a = 10
                a++
                println(a)
                //***************
            }
        }
    }

    suspend fun k(){

    }

}