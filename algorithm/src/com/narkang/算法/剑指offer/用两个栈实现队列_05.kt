package com.narkang.算法

import java.util.*

/**
 * 剑指offer面试题7：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下：请实现他的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */

val stack1 = Stack<Any>()
val stack2 = Stack<Any>()

//在尾部添加元素
fun appendTail(item: Any){
    stack1.add(item)
}

//删除元素
fun deleteHead(){
    if(!stack2.empty()){
        stack2.pop()
    }else{
        if(stack1.empty()){
            throw RuntimeException("空栈")
        }else{
            while (!stack1.empty()){
                stack2.push(stack1.pop())
            }
            deleteHead()
        }
    }
}

fun pop(): Any{
    if(!stack2.empty()){
        return stack2.pop()
    }else{
        if(stack1.empty()){
            throw RuntimeException("空栈")
        }else{
            while (!stack1.empty()){
                stack2.push(stack1.pop())
            }
            pop()
        }
    }
    throw RuntimeException()
}

fun main(args: Array<String>) {
    appendTail(1)
    appendTail(2)
    appendTail(3)
    deleteHead()
    appendTail(4)
    deleteHead()
    appendTail(5)
    println("----->>>"+pop())
}

