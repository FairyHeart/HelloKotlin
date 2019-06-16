package com.kotlin.ptsm

import com.HelloWorld

/**
 *  Kotlin 多平台代码的一个关键功能是让公共代码能够依赖平台相关声明的一种方式。
 *  在其他语言中，这通常可以通过在公共代码中构建一组接口并在平台相关模块中实现这些接口来完成。
 *  然而，当在其中某个平台上有一个实现所需功能的库，并且希望直接使用该库的 API 而无需额外包装器时，
 *  这种方法并不理想。此外，它需要以接口表示公共声明，这无法覆盖所有可能情况。
 *
 *  作为替代方案，Kotlin 提供了一种 预期声明与实际声明 的机制。 利用这种机制，公共模块可以定义 预期声明 ，而平台模块可以提供与预期声明相对应的 实际声明
 *
 *  这阐明了几个要点：
 *  1.公共模块中的预期声明与其对应的实际声明始终具有完全相同的完整限定名。
 *  2.预期声明标有 expect 关键字；实际声明标有 actual 关键字。
 *  3.与预期声明的任何部分匹配的所有实际声明都需要标记为 actual。
 *  4.预期声明决不包含任何实现代码。
 *
 *  预期声明并不限于接口与接口成员,还可以将 expect 修饰符应用于其他声明，包括顶层声明以及注解
 */

/*
expect class HelloWord(hello: String) {
    fun hi()
}

expect fun formatString(source: String, vararg args: Any): String

expect annotation class Test

// JVM 模块
actual class HelloWord actual constructor(val hello: String) {
    actual fun hi() {
        println("java $hello ")
    }
}
*/
fun main() {

}
