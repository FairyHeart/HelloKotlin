package com.kotlin.nmnbl

fun main() {

    //匿名内部类的变量名字必须使用 object
    var t = Test()
    t.setInterface(object : ITestInterface {
        override fun testInter(a: Int, b: Int) {
            println("调用匿名内部类")
        }

    })
    t.setInterface { a, b ->
        println(a + b)
    }
}

interface ITestInterface {
    fun testInter(a: Int, b: Int)
}

class Test {

    fun setInterface(test: ITestInterface) {
        test.testInter(2, 3)
    }

    fun setInterface(test: (a: Int, b: Int) -> Unit) {

    }
}
