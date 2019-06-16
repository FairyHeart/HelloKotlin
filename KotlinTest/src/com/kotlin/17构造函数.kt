package com.kotlin.zzhs

fun main(args: Array<String>) {

    //构造函数的声明
    var p = Person("liuc")
    println(p.age)

    //constructor 修饰主构造函数的时候，没有修饰符可以省去，如果有修饰的时候不需要存在
    //构造函数参数的使用var val，加上var和val会自动生成set get方法，否则不会生成

    //init,构造函数中写的代码将在init代码块中执行

    //次构函数constructor,次构函数变量不支持var val，次构造函数可以允许多个

    //主构函数、次构函数、init执行顺序

    //@JvmOverloads让java代码也能识别默认函数

}

class Person constructor(var name: String, var age: Int=18) {

    var number: String? = null

    var card: String? = null

    init {
        println("执行了初始化")
    }

    constructor(name: String, age: Int, number: String) : this(name, age) {
        this.number = number
        println("执行了次构函数")
    }

    constructor(name: String, age: Int, number: String, card: String) : this(name, age, number) {
        this.card = card
    }

}




