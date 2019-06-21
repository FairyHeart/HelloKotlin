package com.test.coroutines

import kotlinx.coroutines.*

/**
 * Author :Guazi
 * Time   :2019-06-16
 * Desc   :协程
 */
fun main(args: Array<String>) {

    test()
    main2()
    testJoin()
    testLaunch()
    testScope()
    testFun()
//    testQ()
    testCancel()
    testTimeout()
}

fun test() {
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000)
        println("world")
    }
    println("hello")//协程已在等待时主线程还在继续
    Thread.sleep(2000)  // 延迟2秒来保证JVM存活，否则执行不会执行协程里面的业务逻辑

//    runBlocking {
//        delay(1000)
//    }
    println("---- Done test ----\n")
}

//这里的 runBlocking<Unit> { …… } 作为用来启动顶层主协程的适配器。我们显式指定了其返回类型Unit，因为在 Kotlin中main函数必须返回Unit类型。
fun main2() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("world")
    }
    println("hello")
//    delay(2000)
    println("---- Done main2 ----\n")
}

//join 等待直到子协程执行结束
fun testJoin() = runBlocking {
    val job = GlobalScope.launch {
        // 启动一个新协程并保持对这个作业的引用
        delay(2000L)
        println("World!")
    }
    job.join() // 等待直到子协程执行结束
    delay(1000)
    println("Hello,")
    println("---- Done testJoin ----\n")
}

//结构化的并发:我们可以在代码中使用结构化并发。 我们可以在执行操作所在的指定作用域内启动协程， 而不是像通常使用线程（线程总是全局的）那样在 GlobalScope 中启动。
fun testLaunch() = runBlocking {
    launch {
        // 在 runBlocking 作用域中启动一个新协程
        delay(2000)
        println("world")
    }
    println("hello")
    println("---- Done testLaunch ----\n")
}

//作用域构建器: coroutineScope 构建器声明自己的作用域。它会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。
// runBlocking 与 coroutineScope 的主要区别在于后者在等待所有子协程执行完毕时不会阻塞当前线程。
fun testScope() = runBlocking {
    launch {
        delay(2000)
        println("task launch")
    }

    coroutineScope {
        // 创建一个协程作用域
        launch {
            delay(5000)
            println("task scope launch")
        }

        delay(1000)
        println("task scope")
    }

    println("task block")
    println("---- Done testScope ----\n")
}

//提取函数重构:将launch内部的代码提取到独立的函数中，得到一个带suspend修饰的函数，称为挂起函数；
//在协程内部可以像普通函数一样使用挂起函数， 不过其额外特性是，同样可以使用其他挂起函数（如本例中的 delay）来挂起协程的执行
fun testFun() = runBlocking {
    launch {
        print()
    }
    println("task block")
    println("---- Done testFun ----\n")
}

suspend fun print() {
    delay(2000)
    println("task launch")
}

//协程很轻量,运行大量的协程
fun testQ() = runBlocking {
    repeat(100000) {
        launch {
            delay(1000)
            println(".")
        }
    }
    println("---- Done testQ ----\n")
}

/*
  取消协程的执行 cancel,如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的
  while (i < 5) 替换为 while (isActive) 并重新运行它,现在循环被取消了。isActive 是一个可以被使用在 CoroutineScope 中的扩展属性。
 *在 finally 中释放资源
 *
 */
fun testCancel() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
//            while (isActive) {
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } finally {
            println("finally")
        }
    }
    delay(1300)
    println("waiting")
//    job.cancel()
    job.cancelAndJoin()
    println("quit")
    println("---- Done testCancel ----\n")
}

fun testTimeout() = runBlocking {
    //    val result = withTimeout(1300L) {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done"
    }
    println("Result is $result")
    println("---- Done testTimeout ----\n")
}