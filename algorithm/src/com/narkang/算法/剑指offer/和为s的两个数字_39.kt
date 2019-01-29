package com.narkang.算法.剑指offer

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * 举例说明
 * 例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15 ，因此输出4 和11 。
 */
fun main(args: Array<String>) {
    var array = intArrayOf(1, 2, 4, 7, 11, 15)
    var result = findNumbersWithSum(array, 15)
    println(result.toString())
}

fun findNumbersWithSum(num: IntArray, sum: Int): ArrayList<Int>{

    var result = ArrayList<Int>()
    if(num.isEmpty()){
        return result
    }

    var ahead = num.size - 1
    var behind = 0

    while (behind < ahead){
        when {
            sum == num[behind] + num[ahead] -> {
                result.add(num[behind])
                result.add(num[ahead])
                return result
            }
            sum < num[behind] + num[ahead] -> ahead--
            else -> behind++
        }
    }
    return result
}