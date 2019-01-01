package com.narkang.算法

/**
 *  输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
fun main(args: Array<String>) {
    var node1 = Node(8, null)
    var node2 = Node(6, node1)
    var node3 = Node(4, node2)
    var head1 = Node(2, node3)

    var node4 = Node(7, null)
    var node5 = Node(5, node4)
    var node6 = Node(3, node5)
    var head2 = Node(1, node6)

    printNode(merge(head1, head2))
}

/**
 *  合并两个递增链表
 */
fun merge(head1: Node?, head2: Node?): Node?{

    var temp1 = head1
    var temp2 = head2

    temp1?:return temp2
    temp2?:return temp1

    var rootNode: Node? = null
    var pointer: Node? = rootNode

    while (temp1 != null && temp2 != null){
        if(temp1.value!! < temp2.value!!){
            if(rootNode == null){

            }else{
                pointer = temp1
                temp1 = temp1.nextNode
            }
        }else{
            if(rootNode == null){

            }
            pointer = temp2
            temp2 = temp2.nextNode
        }
        if (temp1 != null && temp2 != null) pointer = pointer!!.nextNode
    }

    if(temp1 != null){
        pointer!!.nextNode = temp1
    }

    if(temp2 != null){
        pointer!!.nextNode = temp2
    }

    return rootNode
}