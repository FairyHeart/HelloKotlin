package com.kotlin.qj


fun main() {
    //区间的四种定义方式，整形区间和字符区间
    var rang1 = 1..10

    var rang2 = 1.rangeTo(10)

    var rang3 = IntRange(1, 10)

    var rangStr = 'a'..'z'

    //区间的遍历，同for

    //反向区间定义
    var down1 = 10..1 // 正确??? -->错误，输入结果为空
    var down2 = 10 downTo 1
    var down3 = 10.downTo(1)

    //区间的反转
    var down4 = rang1.reversed()

}