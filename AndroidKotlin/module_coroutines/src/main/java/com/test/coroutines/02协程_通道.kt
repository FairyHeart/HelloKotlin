package com.test.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/**
 *1、 通道：延期的值提供了一种便捷的方法使单个值在多个协程之间进行相互传输。 通道提供了一种在流中传输值的方法。
 * 一个 Channel 是一个和 BlockingQueue 非常相似的概念。其中一个不同是它代替了阻塞的put操作并提供了挂起的send，还替代了阻塞的take操作并提供了挂起的receive
 *
 *2、关闭与迭代通道
 *
 *3、构建通道生产者
 */

fun main() {
    testChannel()
    testChannels()
    testNumbers()
    testGetChannel()
    testSendChannel()
    testChannelSize()
    testTime()
}

fun testChannel() = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (i in 1..5) {
            channel.send(i * i)
        }
        channel.close() // 我们结束发送
    }

    //如果通道没有关闭，取出来的数据超过放入数量得到的值为空，如果关闭抛ClosedReceiveChannelException
//    repeat(6) {
//        println(channel.receive())
//    }

    //通道迭代,这里我们使用 `for` 循环来打印所有被接收到的元素（直到通道被关闭）
    for (i in channel) {
        println(i)
    }
    println("Done testChannel \n")
}

//2.构建通道生产者
fun testChannels() = runBlocking {
    val squares = produceSquares()
    squares.consumeEach {
        println(it)
    }
    println("Done testChannels \n")
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x * x)
}

//3.管道:是一种一个协程在流中开始生产可能无穷多个元素的模式
fun testNumbers() = runBlocking {
    val numbers = produceNumbers() // 从 1 开始生产整数
    val squares = square(numbers) // 对整数做平方
    for (i in 1..5) println(squares.receive()) // 打印前 5 个数字
    println("Done testNumbers \n") // 我们的操作已经结束了
    coroutineContext.cancelChildren() // 取消子协程
}

fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    var x = 1
    while (true) send(x++) // 在流中开始从 1 生产无穷多个整数
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}

/*
4.扇出:多个协程也许会接收相同的管道，在它们之间进行分布式工作
注意我们如何使用 for 循环显式迭代通道以在 launchProcessor 代码中执行扇出。 与 consumeEach 不同，
这个 for 循环是安全完美地使用多个协程的。如果其中一个生产者协程执行失败，其它的生产者协程仍然会继续处理通道，
而通过 consumeEach 编写的生产者始终在正常或非正常完成时消耗（取消）底层通道。*/
fun testGetChannel() = runBlocking {

    val producer = produceNumbers2()
    repeat(5) {
        launchProcessor(it, producer)
    }

    delay(1000)
    producer.cancel()   // 取消协程生产者从而将它们全部杀死
    println("Done testGetChannel \n")
}

fun CoroutineScope.produceNumbers2(): ReceiveChannel<Int> = produce {
    var x = 1 // 从 1 开始
    while (true) {
        send(x++) // 产生下一个数字
        delay(100) // 等待 0.1 秒
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
    }
}

//5.扇入:多个协程可以发送到同一个通道。 比如说，让我们创建一个字符串的通道，和一个在这个通道中以指定的延迟反复发送一个指定字符串的挂起函数：
fun testSendChannel() = runBlocking {
    val channel = Channel<String>()
    launch {
        sendStr(channel, "foo", 200)
    }
    launch {
        sendStr(channel, "foo2", 500)
    }
    repeat(6) {
        // 接收前六个
        println(channel.receive())
    }
    coroutineContext.cancelChildren()
    println("Done testSendChannel \n")
}

suspend fun sendStr(channel: SendChannel<String>, str: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(str)
    }
}

//6.带缓冲的通道
//Channel() 工厂函数与 produce 建造器通过一个可选的参数 capacity 来指定 缓冲区大小 。
// 缓冲允许发送者在被挂起前发送多个元素， 就像 BlockingQueue 有指定的容量一样，当缓冲区被占满的时候将会引起阻塞。
fun testChannelSize() = runBlocking {
    val channel = Channel<Int>(4)// 启动带缓冲的通道
    val sender = launch {
        repeat(10) {
            println("send $it")
            channel.send(it) // 将在缓冲区被占满时挂起
        }
    }
    delay(1000)
    repeat(3) {
        channel.receive()
    }
    sender.cancel()
    println("Done testChannelSize")
}

//7.计时器通道
fun testTime() = runBlocking {
    println("\n")
    val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0) //创建计时器通道
    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Initial element is available immediately: $nextElement") // 初始尚未经过的延迟

    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() } // 所有随后到来的元素都经过了 100 毫秒的延迟
    println("Next element is not ready in 50 ms: $nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100 ms: $nextElement")

    // 模拟大量消费延迟
    println("Consumer pauses for 150ms")
    delay(150)
    // 下一个元素立即可用
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is available immediately after large consumer delay: $nextElement")
    // 请注意，`receive` 调用之间的暂停被考虑在内，下一个元素的到达速度更快
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")

    tickerChannel.cancel() // 表明不再需要更多的元素
}