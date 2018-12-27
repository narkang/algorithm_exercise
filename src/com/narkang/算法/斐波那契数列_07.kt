package com.narkang.算法

/**
斐波那契数列
  */

fun main(args: Array<String>) {
    println("结果："+fibonacci(5))
}

private fun fibonacci(n: Int): Int {

    if(n <= 0) return 0

    if(n == 1 || n == 2) return 1

    //前前一个
    var prePre = 1
    //前一个
    var pre = 1
    //当前
    var current = 2

    var i = 3
    while (i++<=n){
        current = pre + prePre

        pre = current

        prePre = pre
    }

    return current
}