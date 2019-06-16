package com.kotlin.cxl

fun main() {

    //抽象类的定义abstract，抽象类里面可以没有抽象方法，抽象方法一定是抽象类，抽象类只能单继承，抽象类可以继承抽象类
//    var son = Son(10)

}

//⚠️抽象类里面的构造函数如果有默认值，对子类是否生效？？？？--》不生效
abstract class Father(var name: String) {
    abstract fun interest()
}


class Son(name: String, age: Int) : Father(name) {
    override fun interest() {

    }
}
