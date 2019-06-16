package com.kotlin.kzcl

fun main(args: Array<String>) {

    /*  ? 可空变量类型，表示该变量可以为空
        !! 非空断言，通知编译器不做非空校验，如果运行时发现变量为空，就抛出异常；
        ?. 空安全调用符，表示一旦变量为空就返回null
        ?: 表示一旦变量为空，就返回该运算符右边的表达式
    * */

    var str: String? = null

    println(str?.length)//str1.length编译通过不过，str1为空的时候直接返回null
    println(str?.substring(0, 1)?.length ?: -1)//为空的时候直接返回-1
    println(str!!.length)//强制当作非空处理，如果真的为空抛出异常（

}

