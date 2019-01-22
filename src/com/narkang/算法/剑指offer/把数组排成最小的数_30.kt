package com.narkang.算法

import java.util.*

/**
 * https://blog.csdn.net/gg543012991/article/details/52601195
 * https://blog.csdn.net/zz0129/article/details/81301263
 *
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *例子说明：
 *
 *例如输入数组{3， 32, 321}，则扫描输出这3 个数字能排成的最小数字321323。
 */
fun main(args: Array<String>) {

    var numbers = arrayOf("3", "32", "321")
    printMinNumber(numbers)

}

fun printMinNumber(numbers: Array<String>){

    if(numbers.isEmpty()) return

    var arrayList = arrayListOf<String>()
    for (i in numbers){
        arrayList.add(i)
    }

    arrayList.sortWith(Comparator { p0, p1 ->
        var s1 = p0 + p1
        var s2 = p1 + p0
        s1.compareTo(s2)
    })

    println(arrayList.joinToString(""))
}