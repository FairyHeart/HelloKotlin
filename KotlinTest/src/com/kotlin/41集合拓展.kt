package com.kotlin.jhtz

fun main() {
//    yuansuTest()
//    shunxuTest()
//    yingsheTest()
//    guolvTest()
//    shengchanTest()
//    tongjiTest()
    qita()
}

/**
 * 元素操作符：
 * contains(元素) : 检查集合中是否包含指定的元素，若存在则返回true，反之返回false
 * elementAt(index) : 获取对应下标的元素。若下标越界，会抛出IndexOutOfBoundsException（下标越界）异常，同get(index)一样
 * elementAtOrElse(index,{...}) : 获取对应下标的元素。若下标越界，返回默认值，此默认值就是你传入的下标的运算值
 * elementAtOrNull(index) : 获取对应下标的元素。若下标越界，返回null
 * first() : 获取第一个元素，若集合为空集合，这会抛出NoSuchElementException异常
 * first{} : 获取指定元素的第一个元素。若不满足条件，则抛出NoSuchElementException异常
 * firstOrNull() : 获取第一个元素，若集合为空集合，返回null
 * firstOrNull{} : 获取指定元素的第一个元素。若不满足条件，返回null
 * getOrElse(index,{...}) : 同elementAtOrElse一样
 * getOrNull(index) : 同elementAtOrNull一样
 * last() : 同first()相反
 * last{} : 同first{}相反
 * lastOrNull{} : 同firstOrNull()相反
 * lastOrNull() : 同firstOrNull{}相反
 * indexOf(元素) : 返回指定元素的下标，若不存在，则返回-1
 * indexOfFirst{...} : 返回第一个满足条件元素的下标，若不存在，则返回-1
 * indexOfLast{...} : 返回最后一个满足条件元素的下标，若不存在，则返回-1
 * single() : 若集合的长度等于0,则抛出NoSuchElementException异常，若等于1，则返回第一个元素。反之，则抛出IllegalArgumentException异常
 * single{} : 找到集合中满足条件的元素，若元素满足条件，则返回该元素。否则会根据不同的条件，抛出异常。这个方法慎用
 * singleOrNull() : 若集合的长度等于1,则返回第一个元素。否则，返回null
 * singleOrNull{} : 找到集合中满足条件的元素，若元素满足条件，则返回该元素。否则返回null
 * forEach{...} : 遍历元素。一般用作元素的打印
 * forEachIndexed{index,value} : 遍历元素，可获得集合中元素的下标。一般用作元素以及下标的打印
 * componentX() ： 这个函数在前面的章节中提过多次了。用于获取元素。其中的X只能代表1..5。详情可看下面的例子
 */
fun yuansuTest() {
    val list = mutableListOf("kotlin", "Android", "Java", "PHP", "Python", "IOS", "JavaScript")
    println("  ------   contains -------")
    println(list.contains("JS"))

    println("  ------   elementAt -------")
    println(list.elementAt(2))
    println(list.elementAtOrElse(10, { it }))
    println(list.elementAtOrNull(10))

    println("  ------   get -------")
    println(list.get(2))
    println(list.getOrElse(10, { it }))
    println(list.getOrNull(10))

    println("  ------   first -------")
    println(list.first())
    println(list.first { it.startsWith("Ja") })
    println(list.firstOrNull())
    println(list.firstOrNull { it == "Andrid" })

    println("  ------   last -------")
    println(list.last())
    println(list.last { it == "Android" })
    println(list.lastOrNull())
    println(list.lastOrNull { it == "Android" })

    println("  ------   indexOf -------")
    println(list.indexOf("Android"))
    println(list.indexOfFirst { it == "Android" })
    println(list.indexOfLast { it == "Android" })

    println("  ------   single -------")
    val list2 = listOf("list")
    println(list2.single())     // 只有当集合只有一个元素时，才去用这个函数，不然都会抛出异常。
    println(list2.single { it == "list" }) //当集合中的元素满足条件时，才去用这个函数，不然都会抛出异常。若满足条件返回该元素
    println(list2.singleOrNull()) // 只有当集合只有一个元素时，才去用这个函数，不然都会返回null。
    println(list2.singleOrNull { it == "list" }) //当集合中的元素满足条件时，才去用这个函数，不然返回null。若满足条件返回该元素

    println("  ------   forEach -------")
    list.forEach { println(it) }
    list.forEachIndexed { index, it -> println("index : $index \t value = $it") }

    println("  ------   componentX -------")
    println(list.component1())  // 等价于`list[0]  <=> list.get(0)`
    println(list.component2())  // 等价于`list[1]  <=> list.get(1)`
    println(list.component3())  // 等价于`list[2]  <=> list.get(2)`
    println(list.component4())  // 等价于`list[3]  <=> list.get(3)`
    println(list.component5())  // 等价于`list[4]  <=> list.get(4)`

}

/**顺序操作符：
 * reversed() : 反序。即和初始化的顺序反过来。
 * sorted() : 自然升序。
 * sortedBy{} : 根据条件升序，即把不满足条件的放在前面，满足条件的放在后面
 * sortedDescending() : 自然降序。
 * sortedByDescending{} : 根据条件降序。和sortedBy{}相反
 * */
fun shunxuTest() {
    val list = listOf(-1, -3, 1, 3, 5, 6, 7, 2, 4, 10, 9, 8)
    // 反序
    println(list.reversed())
    // 升序
    println(list.sorted())
    // 根据条件升序，即把不满足条件的放在前面，满足条件的放在后面
    println(list.sortedBy { it % 2 == 0 })
    // 降序
    println(list.sortedDescending())
    // 根据条件降序，和`sortedBy{}`相反
    println(list.sortedByDescending { it % 2 == 0 })
}

/**映射操作符：
 * map{...} : 把每个元素按照特定的方法进行转换，组成一个新的集合。
 * mapNotNull{...} : 同map{}函数的作用相同，只是过滤掉转换之后为null的元素
 * mapIndexed{index,result} : 把每个元素按照特定的方法进行转换，只是其可以操作元素的下标(index)，组成一个新的集合。
 * mapIndexedNotNull{index,result} : 同mapIndexed{}函数的作用相同，只是过滤掉转换之后为null的元素
 * flatMap{...} : 根据条件合并两个集合，组成一个新的集合。
 * groupBy{...} : 分组。即根据条件把集合拆分为为一个Map<K,List<T>>类型的集合。具体看实例
 * associate : 通过制定条件将list转换成map
 * mapKeys : 转换键，值不变
 * mapValues ：键不变，值按条件变化
 * */
fun yingsheTest() {
    val list = listOf("kotlin", "Android", "Java", "", "PHP", null, "JavaScript")
    println(list.map { "str-".plus(it) })
    println(list.mapNotNull { it })
    println(list.mapNotNull {
        if (it?.startsWith("Java") == true) {
            "str-".plus(it)
        } else {
            it
        }
    })
    println(list.mapIndexed { index, s -> index.toString().plus("-").plus(s) })
    println(list.mapIndexedNotNull { index, s -> index.toString().plus("-").plus(s) })
    println(list.flatMap {
        listOf(it, "new-".plus(it))
    })
    println(list.groupBy {
        if (it?.startsWith("java", true) == true) "one" else "two"
    })

    println(list.associate { Pair("a$it", it) })

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
    println(numbers.associateBy { it.first().toUpperCase() })
    println(numbers.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))

    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys {
        it.key.toUpperCase()
    })
    println(numbersMap.mapValues { it.value + it.key.length })
}

data class FullName(val firstName: String, val lastName: String)

fun parseFullName(fullName: String): FullName {
    val nameParts = fullName.split(" ")
    if (nameParts.size == 2) {
        return FullName(nameParts[0], nameParts[1])
    } else throw Exception("Wrong name format")
}

/**过滤操作符：
 * filter{...} : 把不满足条件的元素过滤掉
 * filterIndexed{...} : 和filter{}函数作用类似，只是可以操作集合中元素的下标（index）
 * filterNot{...} : 和filter{}函数的作用相反
 * filterNotNull() : 过滤掉集合中为null的元素。
 * take(num) : 返回集合中前num个元素组成的集合
 * takeWhile{...} : 循环遍历集合，从第一个元素开始遍历集合，当第一个出现不满足条件元素的时候，退出遍历。然后把满足条件所有元素组成的集合返回。
 * takeLast(num) : 返回集合中后num个元素组成的集合
 * takeLastWhile{...} : 循环遍历集合，从最后一个元素开始遍历集合，当第一个出现不满足条件元素的时候，退出遍历。然后把满足条件所有元素组成的集合返回。
 * drop(num) : 过滤集合中前num个元素
 * dropWhile{...} : 相同条件下，和执行takeWhile{...}函数后得到的结果相反
 * dropLast(num) : 过滤集合中后num个元素
 * dropLastWhile{...} : 相同条件下，和执行takeLastWhile{...}函数后得到的结果相反
 * distinct() : 去除重复元素
 * distinctBy{...} : 根据操作元素后的结果去除重复元素
 * slice :  获取所有满足执行下标的元素。
 *
 * */
fun guolvTest() {
    val list1 = listOf(-1, -3, 1, 3, 5, 6, 7, 2, 4, 10, 9, 8)
    val list2 = listOf(1, 3, 4, 5, null, 6, null, 10)
    val list3 = listOf(1, 1, 5, 2, 2, 6, 3, 3, 7, 4, 4, 8, 0)
    println("  ------   filter -------")
    println(list1.filter { it > 1 })
    println(list1.filterIndexed { index, i ->
        index < 6 && i > 3
    })
    println(list1.filterNot { it > 1 })
    println(list2.filterNotNull())

    println("  ------   take -------")
    println(list1.take(5))
    println(list1.takeWhile { it < 5 })
    println(list1.takeLast(5))
    println(list1.takeLastWhile { it > 5 })

    println("  ------   drop -------")
    println(list1.drop(5))
    println(list1.dropWhile { it < 5 })
    println(list1.dropLast(5))
    println(list1.dropLastWhile { it > 5 })

    println("  ------   distinct -------")
    println(list3.distinct())
    println(list3.distinctBy {
        if (it == 0) {
            it + 2
        } else {
            it
        }
    })

    println("  ------   slice -------")
    println(list1.slice(listOf(1, 3, 5, 7)))
    println(list1.slice(IntRange(1, 5)))
}

/**生产操作符：
 * plus() : 合并两个集合中的元素，组成一个新的集合。也可以使用符号+
 * zip : 由两个集合按照相同的下标组成一个新集合，多出的元素不匹配。该新集合的类型是：List<Pair>
 * unzip : 和zip的作用相反。把一个类型为List<Pair>的集合拆分为两个集合。看下面的例子
 * partition : 判断元素是否满足条件把集合拆分为有两个Pair组成的新集合。
 * */
fun shengchanTest() {
    val list1 = listOf(1, 2, 3, 4)
    val list2 = listOf("kotlin", "Android", "Java", "PHP", "JavaScript")

    // plus() 和 `+`一样
    println(list1.plus(list2))
    println(list1 + list2)
    // zip
    println(list1.zip(list2))
    // 组成的新集合由元素少的原集合决定
    println(list1.zip(list2) { it1, it2 ->
        it1.toString().plus("-").plus(it2)
    })
    // unzip
    val newList = listOf(Pair(1, "Kotlin"), Pair(2, "Android"), Pair(3, "Java"), Pair(4, "PHP"))
    println(newList.unzip())
    // partition
    println(list2.partition { it.startsWith("Ja") })
}

/**统计操作符：
 * any() : 判断是不是一个集合，若是，则在判断集合是否为空，若为空则返回false,反之返回true,若不是集合，则返回hasNext
 * any{...} : 判断集合中是否存在满足条件的元素。若存在则返回true,反之返回false
 * all{...} : 判断集合中的所有元素是否都满足条件。若是则返回true,反之则返回false
 * none() : 判断集合是否为空
 * none{...} : 判断集合是否都不满足条
 * max() : 获取集合中最大的元素，若为空元素集合，则返回null
 * maxBy{...} : 获取方法处理后返回结果最大值对应那个元素的初始值，如果没有则返回null
 * min() : 获取集合中最小的元素，若为空元素集合，则返回null
 * minBy{...} : 获取方法处理后返回结果最小值对应那个元素的初始值，如果没有则返回null
 * sum() : 计算出集合元素累加的结果。
 * sumBy{...} : 根据元素运算操作后的结果，然后根据这个结果计算出累加的值。
 * sumByDouble{...} : 和sumBy{}相似，不过sumBy{}是操作Int类型数据，而sumByDouble{}操作的是Double类型数据
 * average() : 获取平均数
 * reduce{...} : 从集合中的第一项到最后一项的累计操作。
 * reduceIndexed{...} : 和reduce{}作用相同，只是其可以操作元素的下标(index)
 * reduceRight{...} : 从集合中的最后一项到第一项的累计操作。
 * reduceRightIndexed{...} : 和reduceRight{}作用相同，只是其可以操作元素的下标(index)
 * fold{...} : 和reduce{}类似，但是fold{}有一个初始值
 * foldIndexed{...} : 和reduceIndexed{}类似，但是foldIndexed{}有一个初始值
 * foldRight{...} : 和reduceRight{}类似，但是foldRight{}有一个初始值
 * foldRightIndexed{...} : 和reduceRightIndexed{}类似，但是foldRightIndexed{}有一个初始值
 * */
fun tongjiTest() {
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2: List<Int> = listOf()

    println("  ------   any -------")
    println(list1.any())
    println(list1.any { it > 2 })

    println("  ------   all -------")
    println(list1.all { it > 2 })

    println("  ------   none -------")
    println(list1.none())
    println(list1.none { it > 7 })

    println("  ------   max -------")
    println(list1.max())
    println(list1.maxBy { it + 2 })

    println("  ------   min -------")
    println(list1.min())        // 返回集合中最小的元素
    println(list1.minBy { it + 2 })

    println("  ------   sum -------")
    println(list1.sum())
    println(list1.sumBy { it + 2 })
    println(list1.sumByDouble { it.toDouble() })

    println(" ------  average -----")
    println(list1.average())

    println("  ------   reduce  -------")
    println(list1.reduce { result, next -> result - next })
    println(list1.reduceIndexed { index, result, next ->
        index + result + next
    })
    println(list1.reduceRight { result, next -> result + next })
    println(list1.reduceRightIndexed { index, result, next ->
        index + result + next
    })

    println("  ------   fold  -------")
    println(list1.fold(3) { result, next -> result - next })
    println(list1.foldIndexed(3) { index, result, next ->
        index + result + next
    })
    println(list1.foldRight(3) { result, next -> result + next })
    println(list1.foldRightIndexed(3) { index, result, next ->
        index + result + next
    })

}

/**
 * 关联函数：
 * associate ：通过制定条件将list转换成map，key和value都是自定义
 * associateTo : 指定默认map
 * associateWith ：创建map，map的key为集合的元素值，值按条件自动生成
 * associateBy ：创建map，map的key 按条件生成，value为集合的元素值
 *
 * flatten : 嵌套集合组合成一个新的集合
 * flatMap ：嵌套集合按条件组合成一个新的集合
 *
 * 集合转字符串：
 * joinTo ：将集合转字符串，将结果附加给指定的对象
 * joinToString ： 集合转字符串，默认","分割，
 *                 separator：指定分隔符，prefix：前缀，postfix：后缀，limit：限制显示数量，truncated：超出数量元素默认显示符，transform：自定义处理元素
 *
 * chunked : 将集合分解为制定大小的部分
 * windowed : 您可以检索给定大小的所有可能范围的集合元素，
 *            step定义两个相邻窗口的第一个元素之间的距离，默认值为1，
 *
 * fill: 替换所有元素
 *
 * shuffle:随机输出 shuffled也是随机输出，会自动转集合
 * reverse ：反转，reversed 反转，会自动转集合
 *
 * union: 要将两个集合合并为一个集合
 * intersect: 要查找两个集合（两个集合中都存在的元素）之间的交集
 * subtract: 要查找其他集合中不存在的集合元素，剔除制定元素之后的集合
 */

fun qita() {
    println("   --- associate ---")
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    println(numbers.associate {
        it.length to "value".plus(it.length)
    })
    val map = mutableMapOf(1 to "haha")
    println(numbers.associateTo(map) {
        it.length to "value".plus(it.length)
    })
    println(numbers.associateWith { it.length })
    println(numbers.associateBy { it.length })

    println("\n   --- flatten ---")
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
    println(numberSets.flatMap { it ->
        it.filter { it > 3 }
    })

    println("\n   --- join ---")
    println(numbers)
    var sb = StringBuffer("haha ")
    println(numbers.joinTo(sb))
    println(numbers.joinToString())
    println(
        numbers.joinToString(
            separator = "|",
            prefix = "start : ",
            postfix = " :end",
            limit = 3,
            truncated = "......."
        ) {
            if (it == ("one")) it.plus("_one") else it
        })

    println("\n   --- join ---")
    val list = (0..13).toList()
    println(list.chunked(3))
    println(list.chunked(3) { it.sum() })

    println("\n   --- windowed ---")
    println(numbers.windowed(2))
    println(numbers.windowed(2, 2, partialWindows = true))
    println(list.windowed(3) { it.sum() })

//    println("  ------   fill -------")
//    numbers.fill("3")
//    println(list)

    println("\n  ------   shuffle -------")
    numbers.shuffle()
    println("shuffle : $numbers")
    val list2 = mutableListOf(-1, -3, 1, 3, 5, 6, 7, 2, 4, 10, 9, 8)
    list2.reverse()
    println("shuffled : $list2")
    println("shuffled : ${list2.reversed()}")

    println("\n  ------   union -------")
    val numb = setOf("one", "two", "three")
    println(numb union setOf("four", "five"))
    println(setOf("four", "five") union numb)
    println(numb intersect setOf("two", "one", "five"))
    println(numb subtract setOf("three", "four"))
    println(setOf("four", "three") subtract numb) // same output
}
