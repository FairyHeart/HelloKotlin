package com.kotlin.sjjl


/*
*编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
  equals() / hashCode() toString()
  componentN() functions 对应于属性，按声明顺序排列
  copy() 函数
  如果这些函数在类中已经被明确定义了，或者从超类中继承而来，就不再会生成。

  为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
  1.主构造函数至少包含一个参数。
  2.所有的主构造函数的参数必须标识为val 或者 var ;
  3.数据类不可以声明为 abstract, open, sealed 或者 inner;
  4.数据类不能继承其他类 (但是可以实现接口)。
*
* */
fun main() {

//    var inst = Instance("普通菜", 100, 10)
//    println(inst.component1())

    //解构
//    var (n, f, p) = Instance("普通菜", 150, 15)
//    println(n)
}

/*
   数据类的定义data 相当于java里面的bean
   自动实现 构造方法、get set方法、tostring 、hashCode、equals、copy

   component1 获取第一个参数的值
*/
data class Instance(var name: String, var fee: Int, var price: Int)