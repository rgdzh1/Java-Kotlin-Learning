##### 概述
- CoroutineScope: 为新的协程去定义一个作用域.
    1. 每一个协程构建器(如:launch,async)都是CoroutineScope的一个扩展,并且会继承CoroutineScope中的CoroutineContext来自动的传播其中的元素和可取消的特性.
    2. 创建一个作用域对象建议使用CoroutineScope()或者MainScope()工厂函数实现,额外的上下文元素可以通过plus(+)运算赋值到作用域上.
    3. 每一个协程构建器或者Scope函数,都提供了自己的作用域以及Job实例到自己所运行的内部代码块当中,根据约定,父协程会等待代码块中所有内部子协程完成后才会去完成自身.
- CoroutineContext: 协程上下文,是一些元素的集合,主要包括Job和CoroutineDispatcher元素,可以代表一个协程的场景.它继承自CoroutineScope.
- EmptyCoroutineContext:空的协程上下文.
- CoroutineDispatcher:协程调度器,决定协程所在的线程或线程池.它可以指定协程运行在特定的线程或线程池或不指定任何线程(这样协程就会运行于当前线程).
- coroutines-core:一个jar包,CoroutineDispatcher有三种标准实现:
    1. Dispatchers.Default
    2. Dispatchers.IO
    3. Dispatchers.Main
    4. Dispatchers.Unconfined,Unconfined就是不指定线程
- Job:任务,封装了协程中需要执行的代码逻辑,Job可以取消并且有简单的生命周期,它有几种状态:
    |State                | isActive  |  isCompleted  | isCancelled   |
    |---------------------|-----------|---------------|---------------|
    | New(新建)            | false     | false         | false         |
    | Active(活动)         | true      | false         | false         |
    | Completing(正在完成)  | true      |   false       |   false       |
    | Cancelling(正在取消)  |  false    |  false        | true          |
    | Cancelled(已经被取消) | false     |  true          |  true        |
    | Completed(已经完成)   |   false   |  true         |  false        |
- Deferred: Job完成时没有返回值,如果需要返回值的话,应该使用Deferred,它是Job的子类.
- CoroutineScope.launch函数属于协程构建器中的一种.
    1. 启动一个协程,不会阻塞当前线程.并且返回一个协程引用Job,返回的Job被取消,协程也会被取消. 
    2. 如果没有指定CoroutineDispatcher或者没有其他的ContinuationInterceptor,默认的协程调度器就是Dispatchers.Default,它指定的线程为共有线程池,线程数量至少2,最大与CPU数相同.
- runBlocking: 创建一个新的协程,同时阻塞当前线程,直到协程结束后当前线程才继续运行.
- withContext: 不会创建新的协程,在指定协程上运行挂起代码块,并挂起该协程直到代码块运行完成,再接着向下执行该协程代码块.
- CoroutineScope.async:可以实现与lanuch一样的效果,在后台创建一个新协程,唯一区别是它有返回值,返回值为Deferred类型.

















   