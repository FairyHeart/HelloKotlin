package com.kotlin.f

fun main(args: Array<String>) {

    /*--
    *遍历循环：java中for(item:list),kotlin中使用in代替“：”，
    *具体语句“for(item in list)”或者“for(i in 数组变量.indices)”，kotlin取消了“for(初始；条件；增减)”这个规则
    * withIndex
    *
    * kotlin额外提供until、step、downTo这些关键字已达到更加灵活的条件判断
    * until:左闭又开区间，合法值包括1，但是不包括100
    * set : 每次递增，step后面的数字为递增数，每次递增4
    * downTo : 递减
    * */

    var str = "abcd"

    //输出字符
    for (c in str) {
    }

    //输出角标
    for (index in str.indices) {
//        println(index)
    }

    //输出角标和字符
    for ((index, value) in str.withIndex()) {
//        println("$index $value")
    }

    //forEach写法
    str.forEach {
    }
//
    str.forEachIndexed { index, c ->
        //        println("$index $c")
    }

    //continue break 只能用于for循环，不能用于foreach循环

    //标签处返回
    loop@ for (a in str) {
        for (b in str) {
            if (a == 'b' && b == 'b') {
                break@loop
            }
            println("$a $b")
        }
    }

    //forEach使用return跳出循环
    str.forEach loop@{
        if (it.equals("d")) {
            return@loop
        }
    }
    println("xxx")

    for (i in 11 until 20) {//[  )
        println(i)
    }

    for (i in 1..10 step 2) {
    }

    for (i in 20 downTo 10 step 2) {
    }

    //while 循环,while循环，满足条件才会执行,do while循环，不满足条件也会执行一次
    var a = 10
    while (a < 10) {
    }

    do {
    } while (a < 10)
}