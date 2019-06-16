package com.kotlin.bb

fun main(args: Array<String>) {

    /*
    * 闭包 lambad表达式 函数式编程 函数可以作为方法的返回值 方法可以作为函数的参数
    *
    * */
}

fun test(): () -> Unit {
    var a = 10
    return {
        println(a)
        a++
    }
}
