package com.kotlin.itf

fun main() {

    //接口的定义interface

    //koltin接口的变量不能初始化

    //kotlin接口中的方法能实现

    //@JvmOverloads 不支持接口
    var order:IOrderServcie = Order("x")
    order.confirmOrder()
    order.confirmOrder("xx")
}


interface IOrderServcie {

    var orderId: String

    fun getOrderbyId() {
        println("dd")
    }

    fun confirmOrder(orderId: String = "")

}

class Order(override var orderId: String) : IOrderServcie {
    @JvmOverloads
    override fun confirmOrder(orderId: String) {

    }

}