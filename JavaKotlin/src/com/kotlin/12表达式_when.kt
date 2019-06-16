package com.kotlin.wh


/*---
* kotlin对多路分支的功能做了大幅度扩充，when/else 取代了switch/case，区别如下：
	1. 关键字switch被when取代；
	2. 判断语句“case 常量值：”被新语句 “常量值 -> ”取代；
	3. 每个分支后面的break取消了，因为kotlin默认一个分支处理完成就直接跳出多路语句，所以不再需要break；
	4. 关键字default被else取代；

优势：
    1.when/else允许有返回值；
    2.java中case后面只能跟常量，不能跟变量，局限性很大，kotlin可以引入变量判断，也可以引入具体的运算符表示式；
    3.java中case后面只能跟一个常量，如果多个常量进入同一个分支，就只能并列写5个case，kotlin不需要这么麻烦，
    * 可以多个常量值或者变量值并排在一起用逗号隔开，
    * 也可以使用“in 开始值..结束值”指定区间，不在某个区间则使用“!in 开始值..结束值”
    4.允许判断变量类型

* */
fun main() {
    //java switch(char int byte short 枚举)

    //输入分数得到成绩的等级

    var a = 10
    when (a) {
        1 -> {
            println("d")
        }
        else -> {

        }
    }
}

//条件只需要满足条件，可以是区间、常量、函数等等
//when表达式的原理？简单的when语句switch，复杂的when表达式if else
//when表达式不带参数
//when表达式有返回值
fun printLevel(a: Int): String {
    return when (a) {
        in 80..100 -> "优秀"
        71, 80 -> "良好"
        get() -> "及格"
        50 -> "不及格"
        else -> "未知等级"
    }
}

//when表达式不带参数
fun printLevel2(a: Any): String {
    return when {
        a is Long -> "Long类型"
        a is Int -> "Int类型"
        else -> "未知等级"
    }
}


fun get(): Int {
    return 10
}