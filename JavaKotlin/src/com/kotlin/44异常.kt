package com.kotlin

/**
 * kotlin 中所有异常类都是 Throwable 类的子孙类
 * try是一个表达式，有返回值,finally里面的值不作为返回值
 *
 * Kotlin 没有受检的异常
 *
 * Nothing 类型
 */
fun main() {
    var a: Int? = try {
        1 / 0
        1
    } catch (e: Exception) {
        e.printStackTrace()
        10
    } finally {
        100
    }
    println(a)

    //不会提示io异常，不受检测
    var sb: Appendable = StringBuffer()
    sb.append("x")

    //在 Kotlin 中 throw 是表达式，所以你可以使用它（比如）作为 Elvis 表达式的一部分：
//    val x = null ?: throw IllegalArgumentException("not request null")

    val demo = SimpleDemo(null, null, null)
    val x: String = demo.name ?: fail("not null")
    println(x)
}

//throw 表达式的类型是特殊类型Nothing。 该类型没有值，而是用于标记永远不能达到的代码位置。
// 在你自己的代码中，你可以使用 Nothing 来标记一个永远不会返回的函数：
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

