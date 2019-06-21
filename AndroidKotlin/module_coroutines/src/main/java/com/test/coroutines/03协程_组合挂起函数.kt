package com.test.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 1.默认顺序调用
 * 2.使用 async 并发
 * 3.惰性启动的 async
 */
fun main() {
    testDefault()
    testAsync()
    testLazyAsync()
}

//1.默认顺序调用
fun testDefault() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomthingOne()
        val two = doSomthingTwo()
        println("result = ${one + two}")
    }
    println("completed in $time ms")
    println(" --- Done testDefault ---\n")
}

suspend fun doSomthingOne(): Int {
    delay(1000)
    return 1
}

suspend fun doSomthingTwo(): Int {
    delay(1000)
    return 2
}

//2.使用 async 并发
//async就类似于launch。它启动了一个单独的协程，这是一个轻量级的线程并与其它所有的协程一起并发的工作。不同之处在于launch返回一个Jo并且
// 不附带任何结果值，而 async 返回一个 Deferred —— 一个轻量级的非阻塞 future， 这代表了一个将会在稍后提供结果的 promise。你可以使用.await()
// 在一个延期的值上得到它的最终结果， 但是 Deferred 也是一个 Job，所以如果需要的话，你可以取消它。
fun testAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomthingOne() }
        val two = async { doSomthingTwo() }
        println("result = ${one.await() + two.await()}")
//        one.cancel()
    }
    println("completed in $time ms")
    println(" --- Done testAsync ---\n")

}

//3.惰性启动的 async
//使用一个可选的参数 start 并传值 CoroutineStart.LAZY，可以对 async 进行惰性操作。 只有当结果需要被 await 或者如果一个 start 函数被调用，协程才会被启动
fun testLazyAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) {
            doSomthingOne()
        }
        val two = async(start = CoroutineStart.LAZY) {
            doSomthingTwo()
        }
        one.start()//如果不掉用，调用await也会启动
        two.start()
        println("result = ${one.await() + two.await()}")
    }
    println("completed in $time ms")
    println(" --- Done testLazyAsync ---\n")
}

//4.async 风格的函数
