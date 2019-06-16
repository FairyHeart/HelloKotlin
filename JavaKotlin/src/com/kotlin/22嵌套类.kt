package com.kotlin

fun main() {

    //kotlin嵌套类是静态类static，和外部类没有任何关系，不能访问外部类的属性和方法
    //bytecode

    var inner = OutClass.InnerClass()
    inner.getName()
}

class OutClass {

    var age = 10

    class InnerClass {
        fun getName() {
//            this.age
        }
    }
}