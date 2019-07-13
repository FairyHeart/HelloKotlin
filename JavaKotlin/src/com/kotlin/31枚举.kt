package com.kotlin.mj


fun main() {
    //枚举的定义 enum class
    WHEEK.星期一

    //遍历
    WHEEK.values().forEach {

    }

    //枚举高级用法，枚举里面定义构造函数

}

enum class WHEEK {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

enum class COLOR(var r: Int, var g: Int, var b: Int) {
    RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0)
}