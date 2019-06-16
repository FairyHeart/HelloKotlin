package com.kotlin

import com.kotlin.com.internal.InternalTest
import com.lib.kotlin.LibTest2

/*
* 类属性的修饰符
* abstract    // 抽象类
* final       // 类不可继承，默认属性
* enum        // 枚举类
* open        // 类可继承，类默认是final的
* annotation  // 注解类
*
* 访问权限的修饰符
* private    // 仅在同一个文件中可见
* protected  // 同一个文件中或子类可见
* public     // 所有调用的地方都可见
* internal   // 同一个模块中可见
* */
fun main() {

//    var lib=LibTest()

    var libtes = LibTest2()
    libtes.libTest()

    var internalTest = InternalTest()
    internalTest.internalTest()
}