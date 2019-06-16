package com.kotlin.yzsj

fun main(args: Array<String>) {

    var pair = Pair<String,Int>("张三",20)
    var pair2 = "张三" to 20

    println(pair2.first)
    println(pair2.second)

    var triple = Triple("李四",30,"16657138888")
    println(triple.first)

}

