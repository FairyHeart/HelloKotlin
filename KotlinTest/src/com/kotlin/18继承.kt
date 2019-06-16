package com.kotlin.jc

fun main(args: Array<String>) {

    //kotlin的类、属性、方法都是final的，不能被继承，需使用open关键字才能进行重写

    //override

    var father = Father()
    var son = Son()
//    son.age=20
    println(son.age)
    son.smoking()
}

open class Father {
    var name = ""
    var age = 30

    open fun smoking() {
        println("喜欢抽烟")
    }
}

class Son : Father() {

    override fun smoking() {
        super.smoking()
        println("抽烟喝酒")
    }
}
