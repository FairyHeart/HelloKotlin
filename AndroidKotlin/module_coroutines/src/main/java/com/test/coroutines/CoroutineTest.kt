package com.test.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Author :Guazi
 * Time   :2019-06-16
 * Desc   :协程
 */
fun main(args: Array<String>) {

//    test()
//    testJoin()
    testLaunch()
}

fun test() {
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000)
        println("world")
    }
    println("hello")//协程已在等待时主线程还在继续
//    Thread.sleep(2000)

    runBlocking {
        delay(1000)
    }
}

//这里的 runBlocking<Unit> { …… } 作为用来启动顶层主协程的适配器。我们显式指定了其返回类型Unit，因为在 Kotlin中main函数必须返回Unit类型。
fun main2() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("world")
    }
    println("hello")
    delay(2000)
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
}

fun testLaunch() = runBlocking {
    launch {
        delay(1000)
        println("world")
    }
    println("hello")
}