package com.kotlin.tjyj

fun main() {
    var a = 10
    var b = 5
    var c = if (a >= b) a else b
}

//一行语句的时候可以省略{}
// if语句是有返回值的
// if返回的是函数里面最后一行的内容
//kotlin没有三元运算符
fun testIf2(a: Int, b: Int): Int {
    return if (a >= b) a else b
}

fun testIf(a: Int, b: Int): Int {
    if (a >= b) {
        println("dd")
        return a
    } else {
        return b
    }

}



