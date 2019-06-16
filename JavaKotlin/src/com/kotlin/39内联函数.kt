package com.kotlin.nlhs

import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
    inlineFunc("inline") {
        println("hello")
    }
    otherFunc()

    //传递函数类型的变量作为参数不会被内联
    val action: () -> Unit = {
        println("hello")
    }
    inlineFunc("inline", action)

    //禁止内联
    foo({
        println("inline")
    }, {
        println("noinline")
    })


}

/**
 * 1、为什么使用内联函数：当我们使用lambda表达式时，它会被正常地编译成匿名类。这表示每调用一次lambda表达式，一个额外的类就会被创建，
 * 并且如果lambda捕捉了某个变量，那么每次调用的时候都会创建一个新的对象，这会带来运行时的额外开销，导致使用lambda比使用一个直接
 * 执行相同代码的函数效率更低。
 *
 * 2、内联定义和原理：使用inline声明的函数，它的函数体就是内联的，在函数被调用的时候编译器并不会生成函数调用的代码，而是 使用函数实现的真实代码替换每一次的函数调用。
 *
 * 3、禁止内联：
 * 如果希望只内联一部分传给内联函数的 lambda 表达式参数，那么可以用 noinline 修饰符标记不希望内联的函数参数：
 *
 * 4、内联函数的限制：可以内联的 lambda 表达式只能在内联函数内部调用或者作为可内联的参数传递， 但是 noinline 的可以以任何我们喜欢的方式操作：存储在字段中、传送它等等
 * 传递函数类型的变量作为参数不会被联内：
 * 可内联的参数传递可内联：inlinefunc2中的action函数会内联
 *
 * 5、在两个不同的位置使用同一个内联函数
 * 如果在两个不同的位置使用同一个内联函数，但是用的是不同的lambda，那么内联函数会在每一个被调用的位置分别内联，
 * 内联函数的代码会被拷贝到使用它的两个不同位置，并把不同的lambda替换到其中。
 * */
inline fun inlineFunc(prefix: String, action: () -> Unit) {
    println("before $prefix")
    action()
    println("after $prefix")

    inlineFunc2(action)
}

inline fun inlineFunc2(action: () -> Unit) {
    action()
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    inlined()
    notInlined()
}

//在两个不同的位置使用同一个内联函数
fun otherFunc() {
    inlineFunc("otherFunc inline") {
        println("otherFunc hellp")
    }
}

