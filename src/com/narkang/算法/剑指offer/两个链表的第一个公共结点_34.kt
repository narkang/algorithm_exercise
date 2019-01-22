package com.narkang.算法

/**
 *  输入两个链表，找出它们的第一个公共结点。
 */
fun main(args: Array<String>) {

    var node1 = Node(1, null)
    var node2 = Node(2, node1)
    var node3 = Node(3, node2)
    var head = Node(4, node3)

    var node5 = Node(3, node2)
    var node4 = Node(3, node5)
    var head2 = Node(4, node4)

    var commonNode = findFirstCommonNode(head, head2)
    println(commonNode?.value)
}

fun findFirstCommonNode(_pHead1: Node?, _pHead2: Node?): Node?{
    var pHead1 = _pHead1
    var pHead2 = _pHead2

    if(pHead1 == pHead2) return pHead1

    var pHead1Length = getNodeLength(pHead1)
    var pHead2Length = getNodeLength(pHead2)

    if(pHead1Length > pHead2Length){
        for(i in 0 until pHead1Length - pHead2Length){
            pHead1?.nextNode?.let { pHead1 = it }
        }
    }else if(pHead2Length > pHead1Length){
        for(i in 0 until pHead2Length - pHead1Length){
            pHead2?.nextNode?.let { pHead2 = it }
        }
    }

    var flag = true
    var p: Node? = null
    while (flag){

        if(pHead1 == pHead2){
            p = pHead1
            flag = false
        }else{
            pHead1 = pHead1?.nextNode?:null
            pHead2 = pHead2?.nextNode?:null
        }

    }

    return p
}

/**
 *  获取节点长度
 */
fun getNodeLength(_pHead: Node?): Int{
    var length = 0
    var pHead: Node? = _pHead

    while (pHead != null){
        length++
        pHead = pHead.nextNode
    }

    return length
}