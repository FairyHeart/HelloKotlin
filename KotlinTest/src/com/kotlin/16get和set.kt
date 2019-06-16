package com.kotlin.gs


fun main(args: Array<String>) {

    var p = Person()
    p.age = 10


    //koltin字段是私有属性，会自动生成get set方法

    //修改访问器的可见性，私有set get方法

    //set get方法体修改

    //field 关键字
}

class Person {

    var name: String? = null
        private set //私有化set方法

    var age: Int = 0
        set(value) {
            if (value < 100) {
                this.age = value//死循环
//                field = value
            }
        }
}

