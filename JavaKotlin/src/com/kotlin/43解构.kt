package com.kotlin.jg

/**
 * 有时把一个对象解构成很多变量会很方便,这种语法称为解构声明
 *
 * 解构声明原理：在声明数据类的时候，会自动生成componentN()方法，对应按声明顺序出现的所有属性，
 *   如name就是component1()，age就是component2()，而解构声明的val (dName, dAge)事实上就
 *   是调用component1()和component2()方法。
 *
 * 自动生成component方法的都可以使用解构声明
 *
 * 下划线用于未使用的变量
 */

fun main() {
    val (name, age, _) = getPerson("liucj", 18, "x")
    println(name)
    println(age)

    //for循环中的解构
    val map = mapOf(1 to 1, 2 to 2)
    for ((key, value) in map) {
        println("key = $key value = $value")
    }

    //lambda表达式中的解构
    map.mapValues { (key, value) ->
        println("key = $key value = $value")
    }
    //指定整个解构的参数的类型或者分别指定组件的类型
    map.mapValues { (key, value): Map.Entry<Int, Int> ->
    }

    map.mapValues { (_: Int, value: Int) ->
    }
}

data class Person(var name: String, val age: Int, val cardNo: String?)

fun getPerson(name: String, age: Int, cardNo: String? = null): Person {
    return Person(name, age, cardNo)
}