package com.narkang.算法

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使
 * 得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 */
fun main(args: Array<String>) {
    var array = arrayOf(1, 4, 4, 2, 2, 1, 7, 3)
    swapOddEven(array)
    array.forEach(::println)
}

/**
 *  排序数组中的元素，使奇数位于前半部分，偶数位于后半部分
 */
fun swapOddEven(array: Array<Int>?){

    //如果输入的数组位空，或者数组长度小于2就直接返回
    if(array == null || array.size < 2) return

    var start = 0
    var end = array.size - 1
    while (start < end){

        //找偶数
        while (start < end && array[start] %2 != 0){
            start ++
        }

        //找奇数
        while (start < end && array[end] %2 == 0){
            end --
        }

        //数据交换
        var temp = array[start]
        array[start] = array[end]
        array[end] = temp
    }
}