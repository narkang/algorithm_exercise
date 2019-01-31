package com.narkang.算法

import java.util.*

/**
 *  链表节点
 */
class ListNode(value: Int) {
    var value = value
    var next: ListNode? = null
}

/**
 *  从尾部打印单链表
 */
fun printListFromTailToHead(listNode: ListNode?){
    val stack = Stack<Int>()
    var temListNode = listNode
    while (temListNode != null){
        stack.push(temListNode.value)
        temListNode = temListNode.next
    }
    val list = arrayListOf<Int>()
    while (!stack.isEmpty()){
        list.add(stack.pop())
    }
    list.forEach(::print)
}

fun main(args: Array<String>) {

    val listNode = ListNode(1)
    val listNode2 = ListNode(2)
    val listNode3 = ListNode(3)

    listNode.next = listNode2
    listNode2.next = listNode3

    printListFromTailToHead(listNode)
}