package com

import com.kotlin.SimpleDemo

class HelloWorld {

}

fun main(args: Array<String>) {
    println("hello world")

    var list: List<String>? = null

    println(!list.isNullOrEmpty())
    if (list?.isNotEmpty() == true) {
        println("dd")
    }

    var simple = SimpleDemo(null, null, null)
    var str = simple.name
    if (str?.isNotEmpty() == true) {

    }

    var simple2: SimpleDemo? = null
    println(simple2?.name ?: 0)

    println(0 == null)
}