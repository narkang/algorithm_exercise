package com.narkang.算法

/**
 *  输入一个整数n，求从1 到n这n个整数的十进制表示中1 出现的次数。
 *  举例说明：
 *  例如输入12 ，从1 到12 这些整数中包含1 的数字有1、10、11 和12，1 一共出现了5 次。
 *
 */
fun main(args: Array<String>) {

    println("1到n出现1的次数有${numberOf1Between1AndN(10)}")

}

/**
 *  1到n之间1出现的次数
 */
fun numberOf1Between1AndN(n: Int): Int{

    if(n < 0) return 0

    var count = 0
    for (i in 1 .. n){
        count += numberOf1InN(i)
    }

    return count
}

/**
 *  n中1出现的次数
 */
fun numberOf1InN(n: Int): Int{

    var temp = n
    var count = 0

    while (temp > 0){

        if(temp%10 == 1){
            count++
        }
        temp /= 10

    }

    return count

}