package com.kotlin.ljz

fun main() {

    /*
    * 惰性加载（使用的时候加载），且之后初始化一次
    * 使用条件：
    * 1.字段声明 val
    * 2.by lazy成员变量中或者单独存在都能使用
    * 3.by lazy返回值就是最后一行
    * 4.by lazy线程安全
    *
    * 延迟加载lateinit：需要使用的时候初始化，不赋值不能执行
    * 使用条件：
    * 1.字段声明var
    * */
    println(test2)
    println(test2)

    println(test)

}

lateinit var test: String

val test2: String by lazy {
    println("初始化")
    "test"
}



