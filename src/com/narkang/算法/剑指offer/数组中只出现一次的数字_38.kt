package com.narkang.算法.剑指offer

fun main(args: Array<String>) {

    var num: Array<Int?> = arrayOf(1,1,2,2,3,4,4,5,6,6,7,8,9,9)
    var resultNum = searchSingle(num)
    resultNum.forEach(::println)

}

/**
 * 一个整型数组里除了N个数字之外，其他的数字都出现了两次。请写程序找出这N个只出现一次的数字。
 *例子
 *如：int [] nums = {1,1,2,2,3,4,4,5,6,6,7,8,9,9}
 *那么里面只出现一次的数据是：{3,5,7,8}
 *
 *
 *根据set不能重复添加元素依据，如果存在这个值就移除set中重复的值
 */
fun searchSingle(num: Array<Int?>): Array<Int?>{

    if(num.isEmpty() || num.size < 2){
        return num
    }

    var set = HashSet<Int>()
    num.forEach {
        if(!set.add(it!!)){
            set.remove(it)
        }
    }
    var resultNum = arrayOfNulls<Int>(set.size)

    var i = 0
    set.forEach{
        resultNum[i] = it
        i++
    }

    return resultNum
}