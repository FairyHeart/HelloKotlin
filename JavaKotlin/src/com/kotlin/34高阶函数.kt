package com.kotlin.gjhs

fun main(args: Array<String>) {

    println(cacl(1, 3, ::add))

    var d = ::add
    d(2,3)
}

/*
* 高阶函数
*
* */

fun add(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b;
}

//第三个参数是函数类型，说明kotlin里面的函数可以传递函数参数 如果函数里面传递函数参数的话，就称为高级函数
fun cacl(a: Int, b: Int, function: (Int, Int) -> Int): Int {
    var result = function(a, b)
//    function.invoke(a, b)
    return result
}