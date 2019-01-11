package com.narkang.算法

import java.util.*

/**
 *  输入n个整数，找出其中最小的k个数。
 */
fun main(args: Array<String>) {
    var numbers = intArrayOf(4,5,1,6,2,7,3,8)
    var resultNumbers = getLeastNumbers(numbers, 4)
    printResultNumber(resultNumbers)
}


fun printResultNumber(number: List<Int>?){
    for (i in 0 until number!!.size){
        print("${number[i]}\t")
    }
}

fun getLeastNumbers(numbers: IntArray, k: Int): List<Int>?{

    if(numbers == null || k < 1){
        return null
    }

    var data = arrayListOf<Int>()

    Arrays.sort(numbers)
    if(k == 1){
        data.add(numbers[0])
        return data
    }

    for (i in 0 until k){
        data.add(numbers[i])
    }

    return data
}