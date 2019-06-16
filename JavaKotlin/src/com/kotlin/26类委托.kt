package com.kotlin

import kotlin.reflect.KProperty

fun main() {

    //类委托的定义 by
    //两种实现方法，一种是类委托，一种是接口委托
    Pather().wash()

    //属性委托，把属性委托给其他人来控制
    var son = Son()
    son.money = 100.0
    println(son.money)

    Mother(Sister()).wash()

}

interface WashPower {
    fun wash()
}

class Son : WashPower {

    var money: Double by Mother(this)

    override fun wash() {
        println("儿子开始洗碗")
    }
}

class Sister : WashPower {
    override fun wash() {
        println("姐妹开始洗碗")
    }

}

//父亲委托给儿子
class Pather : WashPower by Son()

//母亲可以把洗碗能力委托给洗碗能力的人
class Mother(var washpower: WashPower) : WashPower by washpower {
    operator fun getValue(son: Son, property: KProperty<*>): Double {
        return 100.toDouble() - 20
    }

    operator fun setValue(son: Son, property: KProperty<*>, d: Double) {

    }
}


