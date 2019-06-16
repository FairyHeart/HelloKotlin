package com.kotlin


fun main() {

    //递归，阶乘 5*4*3*2*1
    println(fact(5))

    //递归和迭代的对比 求1到10的和 ,递归的层级比较深的话容易栈内存溢出
//    println(sum(100000)

    //尾递归优化（尾递归：函数在调用自己之后，没有执行其他任何的操作就是尾递归）
    //tailrec 关键字，优化的原则是将递归转化为迭代
    println(sum2(100000))
}

fun fact(n: Int): Int {
    if (n == 1) {
        return 1
    } else {
        return n * fact(n - 1)
    }
}

fun sum(n: Int): Int {
    if (n == 1) {
        return 1
    } else {
        return n + sum(n - 1)//不是尾递归，还调用了n+
    }
}

tailrec fun sum2(n: Int, result: Int = 0): Int {
    if (n == 1) {
        return result + 1
    } else {
        return sum2(n - 1, result + n)
    }
}