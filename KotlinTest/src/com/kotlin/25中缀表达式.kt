package com.kotlin.zzbds

fun main() {
/*
    中缀表达式：让代码更加的简洁易懂
    定义 infix关键字
    中缀表达式使用条件：1.必须是成员函数或扩展函数
                    2.必须只有一个参数
                    3.参数不能是可变参数或者默认参数
    */
    var p = Person()
    p.sayHello("涨三")
    p sayHello "涨三"

    //自定义操作符 区间 、元组 、二元 等
    1 to 1000
    100 downTo 1

}

class Person {
    infix fun sayHello(name: String) {
        println("你好$name")
    }
}
