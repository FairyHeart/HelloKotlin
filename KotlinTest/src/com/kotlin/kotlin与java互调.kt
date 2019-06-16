package com.kotlin

/**
 *
 *
 * @author: Guazi.
 * @date  : 2019/6/4.
 */
class kotlin与java互调 {
}

//@JvmOverloads让java代码也能识别默认函数
//@JvmOverloads不支持接口
class MyKotlin @JvmOverloads constructor() {

    @JvmOverloads
    fun hello(name: String = "") {

    }
}

// @JvmField 让java代码能识别到变量
class MyFile {

    //    @JvmField
    var version = "1.0"
}