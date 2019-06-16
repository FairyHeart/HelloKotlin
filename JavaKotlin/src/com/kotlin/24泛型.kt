package com.kotlin


fun main() {

    //泛型的定义T，类的泛型和泛型函数

    //泛型上限T : Fruit 限制存放的类型必须是当前类或者子类的类型
    var fruitBox1 = FruitBox(Fruit())
    var fruitBox2 = FruitBox(Apple())

    //泛型擦除，获取的类是无法获取到泛型的类型
    //java里面需要反射才能获取到泛型的类型
    var clz = fruitBox1.javaClass.name//获取类的类型
    println(clz)
    println(fruitBox2.javaClass.name)

    //解决擦除方案：1、泛型前加上reified关键字 2、方法前加上inline关键字

    //泛型类型投射 out 接收当前类型或者它的子类，相当于java的 ? extents
    //           in  接受当前类型或者他的父类，相当于java的 ? super
    setFruits(ArrayList<Fruit>())
    setFruits(ArrayList<Apple>())

    //星号投射 * 代表的任何类型,相当于java里面的?
    setFruits3(ArrayList<String>())
    setFruits3(ArrayList<Int>())
}

class Box<T>(var value: T)

fun <T> dd(value: T): T {
    return value
}

class Thing

class FruitBox<T : Fruit>(var value: T)

open class Fruit

class Apple : Fruit()

//Thing::javaClass 获取当前class类型
inline fun <reified T> parseType(value: T) {
    println(T::class.java.name)
}


fun setFruits(fruit: ArrayList<out Fruit>) {
}

fun <T> setFruits2(fruit: ArrayList<T>) {
}

fun setFruits3(fruit: ArrayList<*>) {
}


