package com.narkang.算法

import java.util.*

/**
 * 栈的压入、弹出序列
 */
fun main(args: Array<String>) {
    var pushOrder = intArrayOf(1, 2, 3, 4, 5)
    var popOrder = intArrayOf(4, 5, 3, 2, 1)
    var possible = isPopOrder(pushOrder, popOrder)
    println(if(possible) "是" else "否")
}

/**
 *  push: 压栈序列
 *  pop： 弹栈序列
 */
fun isPopOrder(pushOrder: IntArray, popOrder: IntArray): Boolean{

    val length = pushOrder.size
    var possible = false

    if(length > 0){

        var nextPush = 0
        var nextPop = 0
        var pop = 0
        var push = 0

        val stackData = Stack<Int>()  //辅助栈
        while (nextPop - pop < length){

            //先进行压栈处理，条件是栈顶元素不是要pop的元素
            while (stackData.size == 0 || stackData.peek() != popOrder[nextPop]){
//                if(stackData.size > 0){
//                    var peekValue = stackData.peek()
//                    println()
//                }
                if(nextPush - push == length){
                    break
                }

                stackData.push(pushOrder[nextPush])
                nextPush++
            }

            if (stackData.peek() != popOrder[nextPop]){
                break
            }

            stackData.pop()
            nextPop++
        }

        if(stackData.size == 0 && nextPop - pop == length){
            possible = true
        }
    }
    return possible
}