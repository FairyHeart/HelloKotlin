package com.kotlin.nll

/*
* https://blog.csdn.net/u013064109/article/details/84899657
* */
fun main() {

    val name = Name("Kotlin")
    name.greet() // `greet` 方法会作为一个静态方法被调用
    println(name.length) // 属性的 get 方法会作为一个静态方法被调用

    /**************Type Aliases(类型别名) 与 Inline Classes(内联类)对比*****************/
    val username: UserName = "liu"
    val pwd: PassWord = "123456"
    validate(pwd, username)//不影响

    //当代码被编译的时候，内联类的实例将会被替换成基础类型的值
    //bytecode String username2 = UserName2.constructor-impl("liu");
    val username2 = UserName2("liu")
    val pwd2 = PassWord2("123456")
//    validate2(pwd2,username2)

    /************** 自动装箱和拆箱 *****************/
    val f = Foo(42)

    asInline(f)    // 拆箱操作: 用作 Foo 本身
    asGeneric(f)   // 装箱操作: 用作泛型类型 T
    asInterface(f) // 装箱操作: 用作类型 I
    asNullable(f)  // 装箱操作: 用作不同于 Foo 的可空类型 Foo?

    // 在下面这里例子中，'f' 首先会被装箱（当它作为参数传递给 'id' 函数时）然后又被拆箱（当它从'id'函数中被返回时）
    // 最后， 'c' 中就包含了被拆箱后的内部表达(也就是 '42')， 和 'f' 一样
    val c = id(f)

    //因为内联类既可以表示为基础类型有可以表示为包装器，引用相等（===）对于内联类而言毫无意义

    //名字修饰,由于内联类被编译为其基础类型，因此可能会导致各种模糊的错误，例如意想不到的平台签名冲突：
    var a = UInt2(10)
    compute(a)
}

/**
 *1、有时候，业务逻辑需要围绕某种类型创建包装器。然而，由于额外的堆内存分配问题，它会引入运行时的性能开销。
 *此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，因为原生类型通常在运行时就进行了大量优化，
 *然而他们的包装器却没有得到任何特殊的处理，为解决这个问题引入内联类
 *
 * 2、高性能：内联类包装的基础类型的值，当代码被编译的时候，内联类的实例将会被替换成基础类型的值
 *
 * 3、声明 ： 类的前面加上inline修饰符来声明内联类
 *
 * 4、满足条件：
 * 1、必须含有唯一的一个属性并且在主构函数中初始化，将使用这个唯一的属性来表示内联类的实例
 * 2、属性必须是val类型
 * 3、构造函数必须是public，不能使用private，属性可以是私有
 * 4、不能包含init初始化块
 * 5、不允许类继承，也不能继承另一个类，可以实现接口
 * 6、嵌套类和内部类不能内联，也不支持内联枚举类
 *
 * 5、成员：
 * 内联类支持普通类中的一些功能。特别是，内联类可以声明属性与函数：
 * 方法和属性会作为一个静态方法被调用
 *
 * 6、表示方式：
 * 内联函数会自动装箱拆箱，既可以表示基础类型，也可以表示包装类型，引用相等（===）对于内联类而言毫无意义
 *
 * 7、名字修饰
 *  由于内联类被编译为其基础类型，因此可能会导致各种模糊的错误，例如意想不到的平台签名冲突：
 *  为了缓解这种问题，一般会通过在函数名后面拼接一些稳定的哈希码来重命名函数。 因此，fun compute(x: UInt)
 *  将会被表示为 public final void compute-<hashcode>(int x)，以此来解决冲突的问题。
 *
 * 8、Type Aliases(类型别名) 与 Inline Classes(内联类)对比
 * 因为它们都包含基础类型，所以内联类很容易与类型别名混淆。但是有一些关键的差异使它们在不同的场景下得以应用。
 * 类型别名为基础类型提供备用名称
 *
 *
 * 9、内联类的实验性状态
    内联类的设计目前是实验性的，这就是说此特性是正在 快速变化的，并且不保证其兼容性。在 Kotlin 1.3+ 中使用内联类时，将会得到一个警告，来表明此特性还是实验性的。
    要想移除警告，你必须通过对 kotlinc 指定 -XXLanguage:+InlineClasses参数来选择使用该实验性的特性。
    在 Gradle 中启用内联类：

    compileKotlin {
        kotlinOptions.freeCompilerArgs += ["-XXLanguage:+InlineClasses"]
    }
 */

//内联类支持普通类中的一些功能。特别是，内联类可以声明属性与函数
inline class Name(val s: String) {
    val length: Int
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }
}

/**************Type Aliases(类型别名) 与 Inline Classes(内联类)对比*****************/
typealias UserName = String

typealias PassWord = String

fun validate(name: UserName, pwd: PassWord) {
    println("userName = $name pwssWord = $pwd")
}

inline class UserName2(val userName: String)

inline class PassWord2(val password: String)

fun validate2(name: UserName2, pwd: PassWord2) {
    println("userName = $name pwssWord = $pwd")
}


/************** 自动装箱和拆箱 *****************/
interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x

inline class UInt2(val x: Int)

// 在 JVM 平台上被表示为'public final void compute(int x)'
fun compute(x: Int) {}

// 同理，在 JVM 平台上也被表示为'public final void compute(int x)'！
fun compute(x: UInt2) {}
