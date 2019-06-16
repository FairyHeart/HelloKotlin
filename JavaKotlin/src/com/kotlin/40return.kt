package com.kotlin.returns

import org.w3c.dom.NameList

fun main() {

    //
    val names = listOf<String>("zhangsan", "liucj", "lisi", "wangwu")

    testFun("liucj", names)
//    testFun2(names)
}

/**
 * 1、非局部返回：如果在lambda中使用return关键字，它会从调用lambda的函数中返回，并不只是从lambda中返回，
 * 这样的return语句叫做 非局部返回，因为它从一个比包含return的代码块更大的代码块中返回了。
 * */
fun testFun(name: String, nameLists: List<String>) {
    nameLists.forEach {
        if (it == name) {
//            return //非局部返回，返回testFun函数
            return@forEach
        }
        println(it)
    }
    println("continue")
}

fun testFun2(nameLists: List<String>) {
    //2、匿名函数：默认使用局部返回
    nameLists.forEach(fun(nameLists) {
        if (nameLists == "liucj") return
        println("$nameLists is not liucj")
    })
    println("continue")
}

inline fun func(action: () -> Unit) {
    println("hi")
}

//3、只有 以 lambda 作为参数的函数是内联函数 的时候才能从更外层的函数返回。在一个非内联的lambda中使用return表达式是不允许的
fun foo() {
    func {
        return
    }

}

/*4、请注意，一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，
 例如来自局部对象或嵌套函数。在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，
 该 lambda 表达式参数需要用 crossinline 修饰符标记:*/
inline fun funCrossInline(crossinline body: () -> Unit) {
    object : Runnable {
        override fun run() {
            body()
        }
    }
}

//5、break 和 continue 在内联的 lambda 表达式中还不可用，但我们也计划支持它们。