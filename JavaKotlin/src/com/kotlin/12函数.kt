package com.kotlin.hs


/*
* ---
	Java使用@Override表示函数重载父类的方法，kotlin使用小写的override在同一行表示重载操作；
    Java使用public表示函数是公用方法，kotlin默认函数就是公开的，所以省略关键字public；
	Java使用void表示函数没有返回值，kotlin不存在关键字void，若无返回参数，则不用特别说明；
	* （***其实kotlin的返回参数是一定存在的，即使开发者不声明任何返回参数，kotlin函数也会默认返回一个Unit类型的对象，这个对象可以省略）
	Kotlin使用关键字fun，表示这里是函数定义，其格式类似于java的关键字class，java不存在fun；
	Java声明输入参数的格式为“变量类型 变量名称”，而Kotlin声明输入参数的格式为“变量名称：变量类型”；
	Kotlin引入了空安全机制，如果某个变量允许为空，就需要在变量名称后面加上？；

    默认参数
    kotlin引入了默认参数单概念，允许在定义函数时直接制定输入参数单默认值，如果调用函数没有给出某个参数的具体值，系统就自动对该函数赋予默认值，避免每次都需要手工赋值的麻烦

    具名参数：调用函数时可以指定某个参数的名字及其数值，具体格式“参数名=参数值”

    java使用”Object…" kotlin添加关键字vararg，具体写法为“vararg name: String?”,函数内部在解析的时候会把可变参数当作数组来处理


* */
fun main() {


    //默认参数和具名参数，解决java里面的方法重载
    //默认参数使用 “变量：类型=默认值”
    //具名参数使用的时候可以指定参数赋值，解决多个参数条用的时候传递值错误的问题
    println(add(1, 2, 3))
    println(add(1, 2))
    println(add(b = 2, c = 3, a = 1))

    //可变参数 vararg 相当于java里面的...
    println(add2(1, 2))
}

fun add(a: Int, b: Int, c: Int = 10): Int {
    return a + b + c
}

//可变参数 vararg 相当于java里面的...
fun add2(vararg x: Int): Int {
    var sum = 0
    x.forEach {
        sum += it
    }
    return sum
}
