package com.kotlin.tzhss


fun main() {

    /*
    * 1.String类拓展 fun String.拓展函数名
    * 2.拓展函数可以访问当前对象里面的字段和方法
    * */

    var str: String? = null
    var bool: Boolean? = str?.myIsEmpty()
    println(bool)

    //父类的拓展函数，子类可以使用，但是不能重写
    var test = Test()
    test.test()
}

fun String?.myIsEmpty(): Boolean {
    return this == null || this.length == 0
}

open class FatherTest

class Test : FatherTest() {
    fun test() {
        println("dd")
    }
}

fun FatherTest.test() {
    println("父类拓展函数")
}