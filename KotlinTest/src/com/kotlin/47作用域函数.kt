package com.kotlin.zyyhs

import kotlin.random.Random

/**
 * Kotlin标准库包含几个函数，其唯一目的是在对象的上下文中执行代码块。当您在提供了lambda表达式的对象上调用此类函数时，它会形成一个临时范围。
 * 在此范围内，您可以在不使用其名称的情况下访问该对象。这些函数称为范围函数：let，run，with，apply，和also。
 * let:let扩展函数的实际上是一个作用域函数，当你需要去定义一个变量在一个特定的作用域范围内，let函数的是一个不错的选择；let函数另一个作用就是可以避免写一些判断null的操作。
 *
 * this 和 it：
 * run，with apply通过关键字将上下文对象作为lambda接收器this
 * let并将also上下文对象作为lambda参数
 *
 * 返回值：
 * apply also返回上下文对象
 * let，run with返回lambda结果。
 * let run apply also 拓展函数，with非拓展函数
 *
 */

fun main() {
    testLet()
    testWith()
    testRun()
    testApply()
    testAlso()
    testTakeIf()
}

//上下文对象可用作参数（it）。返回值是lambda结果
fun testLet() {
    println("   ----let----  ")
    var p = Person("zhangsan", 20, "hangzhou").let {
        it.moveTo("shanghai")
        it.incrementAge()
        println(it)
        it.name.startsWith("li")
    }
    println(p)

    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.filter { it.length > 3 }.let {
        println(it)
    }
    numbers.filter { it.length > 3 }.let(::println)

    //let函数另一个作用就是可以避免写一些判断null的操作
    var str: String? = null
    str?.let {
        println(it.length)
    }

}

//上下文对象可用作receiver（this）。返回值是lambda结果。非拓展函数
fun testWith() {
    println("\n   ----with----  ")
    var p = with(Person("zhangsan", 20, "hangzhou")) {
        name = "lisi"
        city = "shanghai"
        name.startsWith("li")
    }
    println(p)
}

//上下文对象可用作receiver（this）。返回值是lambda结果。
fun testRun() {
    println("\n   ----run----  ")
    var p = Person("zhangsan", 20, "hangzhou")
        .run {
            name = "lisi"
            city = "shanghai"
            name.startsWith("li")
        }
    println(p)
}

//上下文对象可用作receiver（this）。返回值是对象本身
fun testApply() {
    println("\n   ----apply----  ")
    Person("zhangsan", 20, "hangzhou")
        .apply {
            name = "lisi"
            city = "shanghai"
        }
        .apply { incrementAge() }
        .apply { println(this) }
}

//上下文对象可用作参数（it）。返回值是对象本身
fun testAlso() {
    println("\n   ----also----  ")
    Person("zhangsan", 20, "hangzhou")
        .also {
            it.name = "lisi"
            it.city = "shanghai"
        }
        .also { it.incrementAge() }
        .also { println(it) }
}

//允许您在调用链中嵌入对象状态的检查
//如果该对象与谓词takeIf匹配，则返回该对象。否则，它返回null。因此，takeIf是单个对象的过滤功能,takeUnless如果对象与谓词不匹配则返回该对象，如果匹配则返回该对象null
fun testTakeIf() {
    println("\n   ----takeif----  ")
    val number = Random.nextInt(100)
    println(number.takeIf { it % 2 == 0 })
    println(number.takeUnless { it % 2 == 0 })

    display("abcd", "d")

}

data class Person(var name: String, var age: Int, var city: String) {
    fun incrementAge() {
        age++
    }

    fun moveTo(newCity: String) {
        city = newCity
    }

}

fun display(input: String, sub: String) {
    input.indexOf(sub).takeIf { it >= 0 }?.let {
        println("$sub found , postition : $it")
    }
}