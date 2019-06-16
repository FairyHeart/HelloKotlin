package com.kotlin.nbn

fun main() {

    //内部类的创建，inner关键字，依懒外部类

    //内部类访问外部类的属性和方法 this@tag

    var inner = OutClass().InnerClass()
    inner.getName()
}

class OutClass {

    var age = 10

    inner class InnerClass {
        var age = 1
        fun getName() {
            println(this@OutClass.age)
        }
    }
}