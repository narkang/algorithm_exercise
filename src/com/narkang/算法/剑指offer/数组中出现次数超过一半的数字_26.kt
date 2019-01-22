package com.narkang.算法

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
fun main(args: Array<String>) {
    var arrays = intArrayOf(2, 3, 3, 4, 1, 3, 2, 4, 3, 3, 3)
    println(moreThenHalfNum(arrays))
}

/**
 *  找出超过数组长度一半的数字
 */
fun moreThenHalfNum(array: IntArray): Int? {

    if (array == null) return null

    var count = 0 //记录数字出现的次数
    var resultInt: Int? = null
    var number: Int? = null

    for (i in 0 until array.size) {
        if (number == null) {
            number = array[i]
            count++
        } else {
            if (array[i] != number) {
                if (count == 0) {
                    number = array[i]
                    count = 1
                } else {
                    count--
                }
            } else {
                count++
            }
        }
        if (count == 1) {
            resultInt = number
        }
    }

    return if (checkMoreThenHalf(array, resultInt)) {
        resultInt
    } else {
        null
    }
}

/**
 * 检测数组里面的元素是否出现次数超过一半
 */
fun checkMoreThenHalf(array: IntArray, number: Int?): Boolean {

    var times = 0
    for (i in 0 until array.size) {
        if (array[i] == number) times++
    }

    var isMoreThenHalf = true
    if (times * 2 < array.size) {
        isMoreThenHalf = false
    }

    return isMoreThenHalf
}

