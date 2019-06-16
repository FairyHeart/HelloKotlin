package com.kotlin.lbd

fun main(args: Array<String>) {
    cacl(1, 3, ::add)

    //匿名函数 lambda表达式，调用的时候，最后一个参数传递的是匿名函数lambda表达式
println("ddd")
    var ad: (Int, Int) -> Int = { a, b -> a + b }

    cacl(2, 4, { m, n ->
        m + n
    })

    //如果最后一个参数是lambda表达式，可以包（）前移
    cacl(2, 4) { m, n ->
        m + n
    }

    //lambda表达式单独存在
    main2()

}


var d = {
    println("d")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

//第三个参数是函数类型，说明kotlin里面的函数可以传递函数参数 如果函数里面传递函数参数的话，就称为高级函数
fun cacl(a: Int, b: Int, function: (Int, Int) -> Int): Int {
    var result = function(a, b)
    return result
}

fun main2() {
    //没有参数的lambda表达式
//    {
//        println("d")
//    }.invoke()

    {
        println("d")
    }()

}

fun main3() {
    //有参lambda表达式
//    { a: Int, b: Int ->
//        a + b
//    }(3, 4)

    { a: Int, b: Int ->
        a + b
    }.invoke(3, 5)
}