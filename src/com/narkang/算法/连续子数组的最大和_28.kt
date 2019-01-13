package com.narkang.算法

/**
  * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
  *
  * 例子说明：
  *
  * 例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3, 10, -4, 7, 2}。因此输出为该子数组的和18 。
 */
fun main(args: Array<String>) {
    var array = intArrayOf(1, -2, 3, 10, -4, 7, 2, -5)
    var maxNum = findGreatestSumOfSubArray(array)
    println("最大值是$maxNum")
}

/**
 * 查找最大子向量的数组
 */
fun findGreatestSumOfSubArray(array: IntArray): Int{

    if(array.isEmpty()){
        return 0
    }

    var currentMax = 0
    var max = 0

    for(i in array){
        if(currentMax <= 0){
            currentMax = i
        }else{
            currentMax += i
        }
        if(currentMax > max){
            max = currentMax
        }
    }

    return max
}