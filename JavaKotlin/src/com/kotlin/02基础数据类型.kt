package com.kotlin.jcsjlx


const val const: Int = 20

fun main(args: Array<String>) {
    /**----------------------------   变量的声明  ----------------------------------*/

    /**
     * ---
     * var 声明的变量任何时候都允许赋值(声明变量)
     * val 声明的变量只能在第一次声明的时候赋值，可以理解为java中的final（声明常量）
     * int Int 这类关键字在kotlin中是允许当作变量使用的
     *
     * const 常量的声明，相当于java里面的public final static
     * */
    var a = 1

    //智能数据类型推断
    var int = 2

    val week: Int = 7

    //包装数据类型kotlin自动转换
    var hashcode = a.hashCode()

    println(hashcode)

    /**----------------------------   类型转换  ----------------------------------*/
    /**
     *---
     * 不同的数据类型不能相互转换，java小的可以赋值给大的，大的不能赋值值给小的
     * kotlin中不同的数据类型不能直接使用=转换，需要使用自己提供的相应toInt()方法
     * */

    var m: Int = 10
    var n: Long = 10L
//    m = n
//    n = m
    println(m.toLong())
}