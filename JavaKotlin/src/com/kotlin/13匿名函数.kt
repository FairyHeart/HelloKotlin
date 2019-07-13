package com.kotlin


fun main() {

    //函数变量的定义 ::获取函数的引用
    var m = ::add
    //调用
    m(1, 2)
    m.invoke(1, 2)//优势可以处理m为空的情况
    m?.invoke(1, 2)

    //匿名函数 lambda表达式
    var m2: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

}

fun add(a: Int, b: Int): Int {
    return a + b
}