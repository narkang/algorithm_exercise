package com.narkang.算法

/**
 *  题目
 *  给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。
 */
fun main(args: Array<String>) {

    var node1 = Node(1, null)
    var node2 = Node(2, node1)
    var node3 = Node(3, node2)
    var head = Node(4, node3)
    deleteNode(head, node3)
    printNodes(head)
}

/**
 * 打印节点
 */
fun printNodes(head: Node?){
    var temp = head
    while (temp != null){
        println(temp.value)
        temp = temp.nextNode
    }
}

/**
 *  链表节点
 */
class Node(var value: Int?, var nextNode: Node?)

/**
 *  head：        头节点
 *  toBeDeleted:  待删除节点
 */
fun deleteNode(head: Node?, toBeDeleted: Node?): Node?{
    if(head == null || toBeDeleted == null){
        return head
    }

    //如果删除的是头结点
    if(head == toBeDeleted){
        return head.nextNode
    }

    //如果删除的节点是尾节点
    if(toBeDeleted.nextNode == null){

        var temp = head
        while(temp?.nextNode != toBeDeleted){
            temp = head.nextNode
        }
        temp.nextNode = null
    //如果删除的是中间节点，直接用下一个节点替换前一个节点
    }else{
        toBeDeleted.value = toBeDeleted.nextNode?.value
        toBeDeleted.nextNode = toBeDeleted.nextNode?.nextNode
    }

    return head
}