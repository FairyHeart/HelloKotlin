package com.kotlin.znlxzh


fun main() {

    // is相当于java里面的instanceof，如果满足条件，会自动强转
    // as 强转

    var inst: BaseInstance = Instance()

    var newInst = inst as Instance
    newInst.updateFee()

    if (inst is Instance) {
        inst.updateFee()
    }
}

open class BaseInstance {
    fun updatePrice() {
        println("update price")
    }
}

class Instance : BaseInstance() {
    fun updateFee() {
        println("update fee")
    }
}

