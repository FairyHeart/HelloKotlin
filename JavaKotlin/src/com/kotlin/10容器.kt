package com.kotlin.sz

/*
*
*
* */
fun main() {

/*
集合 只读集合 Set 可变集合MuttableSet 初始化setOf mutableSetOf
    集合Set/MutableSet
    容器内部的元素是无顺排列，无法根据下标进行访问
    容器内部元素存在唯一性

    可变集合MutableSet限制：
    add添加的元素无法知道具体位置
    没有修改元素的方法，一旦添加就不能被修改
    remove方法删除指定元素，但是无法删除某个位置的元素

队列 只读队列 List 可变队列MutableList 初始化listOf mutableListOf
    队列是一种元素之间按照顺序排列的容器，比集合多了一下功能
	1. 队列能通过get方法获取指定位置的元素，也可以直接通过下标获得该位置的元素
	2. MutableList的add方法每次都是吧元素添加到队列的末尾，也可以指定添加的位置
	3. MutableList的set方法允许替换或者修改指定位置的元素
	4. MutableList的removeAll方法允许删除指定位置的元素
	5. 除了for-in、迭代器遍历、forEach遍历三种遍历之外，还添加了按元素下标循环遍历的方法
	6. MutableList提供了sort系列方法用于元素重新排序，sortBy方法表示安装指定条件升序排列，sortByDescending方法表示按照指定条件降序排序

映射 只读映射 Map  可变映射 MutableMap 初始化 mapOf mutableMapOf
    映射内部保存的是一组键值对（key-value）
	1. containsKey方法判断是否存在指定键名的元素，containsValue判断是否存在指定键值
	2. MutableMap的put方法，put的时候会自动检测是否存在，存在替换就值，没有放入新值
	3. MutableMap的remove方法通过键名来删除元素
	4. 调用mapOf和mutableMapOf初始化映射时，有两种方法可以表达单个键值对元素，其一采用“key to value”，其二采用Pair配对方式（Pair(key,value)）
*/
    testSet()

}

fun testSet() {
    var instSet: Set<String> = setOf("普通菜", "套餐", "套餐子菜", "加料菜", "自定义菜")
    for (inst in instSet) {
        println("$inst ")
    }
    var iterator = instSet.iterator()
    while (iterator.hasNext()) {
        var inst = iterator.next()
        println("$inst ")
    }
    instSet.forEach {
        println("$it ")
    }
    instSet.forEachIndexed { index, s ->
        println("$index,$s")
    }
}

fun testList() {
    var instList: MutableList<String> = mutableListOf("普通菜", "套餐", "套餐子菜", "加料菜", "自定义菜")
//        instList.sort()
//        instList.sortBy { it.length }
//        instList.sortDescending()
    instList.sortByDescending { it.length }

    for (index in instList.indices) {
        var inst = instList.get(index)
        println("$inst ")
    }
}

fun testMap() {
    var instMap: Map<Int, String> = mapOf(1 to "普通菜", 2 to "套餐", 3 to "套餐子菜", 4 to "加料菜", 5 to "自定义菜")
    var kindMap: MutableMap<Int, String> =
        mutableMapOf(Pair(1, "普通菜"), Pair(2, "套餐"), Pair(3, "套餐子菜"), Pair(4, "加料菜"), Pair(5, "自定义菜"))

    //for-in 循环
    for (item in instMap) {
        println("${item.key}${item.value}")
    }
    //迭代器遍历
    var iterator = kindMap.iterator()
    if (iterator.hasNext()) {
        var item = iterator.next()
        println("${item.key}${item.value}")
    }
    //forEach遍历 API 24以上
    kindMap.forEach { key, value -> println("${key}${value}") }

}