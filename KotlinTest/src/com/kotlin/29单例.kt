package com.kotlin.dlms


/*
  * object单例模式
  * 单例 所有的字段都是static静态，方法不是，字段过多的时候不推荐使用
  * kotlin中没有static关键字，怎么控制字段是否static？
  * */
fun main() {

    //单例的定义 object

    //单例调用方法和成员变量
    Single.singleTest()

    //实现原理？？？

    //怎么控制字段static属性？
    //伴生对象companion,生命属性是静态
    println(Test.test)
    println(Test.printTest())

    println(Single2.instance.test)

}

object Single {

    var name = "single"

    fun singleTest() {
        println("singleTest")
    }
}

class Test {
    //companion表示半生，object表示对象，A表示半生对象的名字，可以不用
    companion object A{
        var test = "test"

        fun printTest(){
            println("半生对象里面的函数")
        }
    }
}

//java中的单列模式
class Single2 {

    var test = "single test"

    companion object {

        val instance: Single2 by lazy {
            Single2()
        }
    }
}

