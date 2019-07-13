package com.kotlin.ysfcz

fun main() {
    var girl1 = Person()
    var girl2 = Person()

    println(girl1 + girl2)
}


//operator 关键字修饰
class Person {
    var name = "涨三"
    var age = 20

    operator fun plus(p: Person): Int {
        return age + p.age
    }
}