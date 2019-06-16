package com.kotlin

import java.io.File

/**
 *类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名。
 * */
fun main(args: Array<String>) {

    val name: Pwd = "123456"

    val maxval: (Int, Int) -> Int = { x, y ->
        x * 2 - y
    }
    max(1, 2, maxval)

    max(1, 2) { x, y ->
        x * 2 - y
    }

    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // 输出 "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // 输出 "[1]"
}

typealias Pwd = String

class A {
    inner class Inner
}

//类对别名
typealias AInner = A.Inner

//函数别名
typealias MyHandler = (Int, Int) -> Int

fun max(a: Int, b: Int, myHandler: MyHandler): Int {
    val c = myHandler(a, b)
    return if (a >= b && a >= c) {
        return a
    } else if (b >= a && b >= c) {
        return b
    } else {
        return c
    }
}

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

