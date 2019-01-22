package com.narkang.算法

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * https://blog.csdn.net/lhl1124281072/article/details/79844431
 */
fun main(args: Array<String>) {

    var node1 = Node(4, null)
    var node2 = Node(3, node1)
    var node3 = Node(2, node2)
    var head = Node(1, node3)
    println("反转前")
    printNode(head)
    println("反转后")
    printNode(reverseList(head))
}

/**
 * 打印链表
 */
fun printNode(head: Node?){

    var temp = head

    while (temp != null){
        print("${temp.value}\t")
        temp = temp?.nextNode
    }
    println()
}

/**
 *  反转单链表
 */
fun reverseList(head: Node?): Node?{

   var temp = head

   if(head == null) return null

   var pre: Node? = null
    var next: Node?

    while (temp != null){

       next = temp.nextNode //先保存下一个节点
       temp.nextNode = pre  //反转当前节点
       pre = temp //移动当前节点到下一个节点
       temp = next //移动当前节点到下一个节点

   }

   return pre  //返回反转后的头节点
}
