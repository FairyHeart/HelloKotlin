@file:JvmName("Foo")

package com.kotlin.zj

import kotlin.reflect.KClass

/**
 * 注解声明annotation 修饰
 *
 * 注解的附加属性可以通过用元注解标注注解类来指定：
 *  @Target 指定可以用该注解标注的元素的可能的类型（类、函数、属性、表达式等）；
 *  @Retention 指定该注解是否存储在编译后的 class 文件中，以及它在运行时能否通过反射可见 （默认都是 true）；
 *  @Repeatable 允许在单个元素上多次使用相同的该注解；
 *  @MustBeDocumented 指定该注解是公有 API 的一部分，并且应该包含在生成的 API 文档中显示的类或方法的签名中。
 *
 *注解可以有接受参数的构造函数
 * 允许的参数类型有：
 *      对应于 Java 原生类型的类型（Int、 Long等）；
 *      字符串；
 *      类（Foo::class）；
 *      枚举；
 *      其他注解；
 *      上面已列类型的数组。
 * 注解参数不能有可空类型，因为 JVM 不支持将 null 作为注解属性的值存储。
 *
 * 如果注解用作另一个注解的参数，则其名称不以 @ 字符为前缀：
 *
 * 如果需要将一个类指定为注解的参数，请使用 Kotlin 类 （KClass）。Kotlin 编译器会自动将其转换为 Java 类，以便 Java 代码能够正常看到该注解及参数 。
 *
 * 注解也可以用于 lambda 表达式,它们会被应用于生成 lambda 表达式体的 invoke() 方法上
 */
@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

@Fancy
class Person {

//标注属性访问器
//    var age = 10
//        @Inject set

    @Fancy
    fun name(@Fancy name: String): String {
        return (@Fancy name)
    }
}

//注解可以有接受参数的构造函数
@Repeatable
annotation class Person2(val type: String)

@Person2("woman")
class Woman

//如果注解用作另一个注解的参数，则其名称不以 @ 字符为前缀
annotation class ReplaceWith(val expression: String)

annotation class Deprecated(val message: String, val replaceWith: ReplaceWith = ReplaceWith(""))

@Deprecated("this function is deprecated", ReplaceWith("newOrderServcie"))
class OrderService

//如果需要将一个类指定为注解的参数，请使用 Kotlin 类 （KClass）。Kotlin 编译器会自动将其转换为 Java 类，以便 Java 代码能够正常看到该注解及参数 。
annotation class Ann(val arg1: KClass<*>)

@Ann(Person::class)
class MyClass

annotation class Suspendable

//注解也可以用于 lambda 表达式,它们会被应用于生成 lambda 表达式体的 invoke() 方法上
val f = @Suspendable { println("annotation lambda") }

/**
 * 注解使用处目标
 * 当对属性或主构造函数参数进行标注时，从相应的 Kotlin 元素生成的 Java 元素会有多个，因此在生成的 Java 字节码中该注解有多个可能位置 。
 * 如果要指定精确地指定应该如何生成该注解，请使用以下语法：
 *      file: 可以使用相同的语法来标注整个文件
 *      property: （具有此目标的注解对Java不可见）
 *      field: 字段
 *      get: （属性 getter）
 *      set: （属性 setter）
 *      receiver: （扩展函数或属性的接收者参数）
 *      param: （构造函数参数）
 *      setparam: （属性 setter 参数）
 *      delegate: （为委托属性存储其委托实例的字段）
 *
 * 可以使用相同的语法来标注整个文件。 要做到这一点，把带有目标 file 的注解放在文件的顶层、package 指令之前或者在所有导入之前（如果文件在默认包中的话）：
 * @file:JvmName("Foo")
 * package org.jetbrains.demo
 *
 * 如果你对同一目标有多个注解，那么可以这样来避免目标重复——在目标后面添加方括号并将所有注解放在方括号内：
 */
class Example(
    @field:Ann(String::class) val foo: String,    // 标注 Java 字段
    @get:Ann(Int::class) val bar: String,         // 标注 Java getter
    @param:Ann(String::class) val quux: String    // 标注 Java 构造函数参数
) {
    //如果你对同一目标有多个注解，那么可以这样来避免目标重复——在目标后面添加方括号并将所有注解放在方括号内：
    @set:[Ann(String::class) Suspendable]
    var name: String? = null
}

//要标注扩展函数的接收者参数
fun @receiver:Fancy String.myExtension() {

}

//数组作为注解参数
annotation class AnnWithArray(val values: IntArray)

@AnnWithArray(values = [1, 2, 4, 5])
class TestAnnWithArray
