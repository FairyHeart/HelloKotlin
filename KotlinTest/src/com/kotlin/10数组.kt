package com.kotlin.sz

fun main() {

    //定义数组并赋值
    var ar = arrayOf("涨三", "李四", "王五")

//    println(ar[2].javaClass.name)
//    println(ar[1].javaClass.name)
//    println(ar.javaClass.name)
    //8中基本数据类型数组
    var arry = IntArray(10) {
        1
    }

    //数组元素的修改
    arry[1] = 3
    arry.set(1, 10)
//    println(arry.get(1))

    //数组元素角标的查找，查不到返回？
    println(ar.indexOf("李"))
    println(ar.lastIndexOf("李四"))

    println(ar.indexOfLast {
        it.equals("李四") || it.contains("dd")
    })
    println(ar.indexOfFirst {
        it.contains("李四")
    })

    //数组的遍历，for循环的时候再讲
    ar.forEach {
    }

    ar.forEachIndexed { index, s ->
    }

    for (a in ar) {
    }

    for (a in ar.indices) {
    }

    for ((index, a) in ar.withIndex()) {
    }


}