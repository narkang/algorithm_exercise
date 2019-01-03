package com.narkang.算法

import java.util.*

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min函数。
 * 在该栈中，调用min、push 及pop的时间复杂度都是O(1)。
 *
 * 思路：添加辅助栈
 */
fun main(args: Array<String>) {

}

class Solution{

    val s1 = Stack<Int>()
    val min = Stack<Int>()

    fun push(node: Int){

        if(min.empty()){
            min.push(node)
        }else{
            val top = min.peek()
            if(top < node){
                min.push(top)
            }else{
                min.push(node)
            }
        }

        s1.push(node)
    }

    fun pop(node: Int){
        if(s1.isNotEmpty()){
            s1.pop()
            min.pop()
        }
    }

    fun min(): Int{
        if(min.empty()){
            return 0
        }

        return min.peek()
    }
}