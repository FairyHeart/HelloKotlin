package com.kotlin.zfc


fun main(args: Array<String>) {

    /**----------------------------   字符串与基础类型的转换 ----------------------------------*/
    //不同类型的转换使用的系统提供的toXXX()方法
    var a = "10"
    a.toInt()

    /**----------------------------   字符串常用方法  ----------------------------------*/

    //比较,== equals比较的是值，===比较的是引用
    var str1 = "abc"
    var str2 = String(charArrayOf('a', 'b', 'c'))
    println(str1 == str2)
    println(str1.equals(str2))
    println(str1 === str2)

    //分割
    var str3 = "张三/李四/王五"
    str3.split("/")

    var str4 = "张三/李四-王五" //???
    var d = str4.split("/", "-")
    d.forEach {
        println(it)
    }

    //截取
    var str5 = "https://www.baidu.com"
    /*
    * 获取前6个字符
    * 把第一个.之前的字符截取
    * 把最后一个.之前的字符截取
    * 把第一个.之后的字符截取
    * 把最后一个.之后的字符截取
    * */
    println(str5.substring(0, 5))
    println(str5.substringBefore("."))
    println(str5.substringBeforeLast("."))
    println(str5.substringAfter("."))
    println(str5.substringAfterLast("."))

    //原样输出字符串
    var str6 = """
       /浙江省
       /杭州市
       /拱墅区
       /二维火科技大厦"""
    println(str6.trimIndent())
    println(str6.trimMargin("/"))

    /**----------------------------   字符串拼接  ----------------------------------*/
    /*
    * ---
    * 直接在字符串中加入“$变量名”即表示此处应用变量的值，如果是运算使用“${运算}”，
    * 特殊符号$需要转义“${‘$’}”,如果单个美元符合进行专业，可以使用 \$
    * ${方法}
    * */

    var age = 18
    println("年龄$age 岁")//年龄18 岁
    println("年龄${get()}岁")//年龄18岁
    println("美元符号(\$) ${'$'} ${"$88"}")//美元符号($) $ $88

}

fun get(): Int {
    return 10
}