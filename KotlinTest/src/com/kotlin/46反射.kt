package com.kotlin.fs

import com.kotlin.SimpleDemo
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/**
 * 类引用 :  MyClass::class
 * Kotlin 类引用与 Java 类引用不同。要获得 Java 类引用， 请在 KClass 实例上使用 .java 属性
 *
 * 函数引用
 *
 * 属性引用
 *
 * 构造函数引用
 *
 * 与 Java 反射的互操作性
 */
var m = 1

fun main() {
    println(SimpleDemo::class)
    println(com.java.SimpleDemo::class)
    println(com.java.SimpleDemo::class.java)

    //函数引用
    var f: (Int) -> Int = { a -> a + 1 }
    var g: (Int) -> Int = { a -> a + 1 }
    var x: (Int) -> Int = compose(f, g)
    println(x.invoke(2))

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))

    //属性引用
    println(::m.get())
    //属性引用可以用在不需要参数的函数处：
    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length))


    //要访问属于类的成员的属性，我们这样限定它：
    var prop = A::p
    println(prop.get(A(1)))

    //对于扩展属性：
    println(String::lastChar.get("abc"))

    //构造函数引用,无参构造函数 ::B直接访问，有参的如下
    function(10, ::B)
    function(10) { B(it) }//返回一个B对象

    //与 Java 反射的互操作性
    println(A::p.javaGetter)
    println(A::p.javaField)
    //要获得对应于 Java 类的 Kotlin 类，请使用 .kotlin 扩展属性：??具体怎么调用？？
    fun getKClass(o: Any): KClass<Any> = o.javaClass.kotlin

    //绑定的函数与属性引用
    val numberRegex = "abc".toRegex()
    println(numberRegex.matches("abc"))
    val matches = numberRegex::matches
    println(matches("abc"))
    println(strings.filter(matches))

    val str = "abc"::length
    println(str.get())

    //inner 类的构造函数的绑定的可调用引用可通过提供外部类的实例来获得
    val o = Outer()
    val boundInnerCtor = o::Inner
}


fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isOdd(x: Int) = x % 2 == 0
fun length(s: String) = s.length

class A(var p: Int)

val String.lastChar: Char
    get() = this[length - 1]

class B(var age: Int) {
    var name = "b"
}

//无参并返回A类型的函数参数
fun function(age: Int, param: (m: Int) -> B) {
    var b: B = param.invoke(age)
    println(b.name)
}

class Outer {
    inner class Inner
}