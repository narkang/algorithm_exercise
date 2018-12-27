package com.narkang.算法

fun main(args: Array<String>) {
    println("二进制一的个数："+ numOfOne(8))
}

private fun numOfOne(n: Int): Int {

    var input = n

    var result = 0
    for (i in 0 until 32){
        result += input and 1
        input = input ushr 1   //无符号右移
    }

    return result
}