package com.narkang.算法

/**
 * 一、题目
 *输入一个链表，输出该链表中倒数第k 个结点。为了符合大多数人的习惯，本题从1
 *开始计数，即链表的尾结点是倒数第1 个结点．例如一个链表有6 个结点，从头结点
 *开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点。
 *
 *二、解题思路
 *为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两个指针。第一个指针从链表的
 *头指针开始遍历向前走k-1步，第二个指针保持不动；从第k 步开始，第二个指针也开始从链表的
 *头指针开始遍历。由于两个指针的距离保持在k-1 ， 当第一个
 *（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。
 */
fun main(args: Array<String>) {

    var node1 = Node(1, null)
    var node2 = Node(2, node1)
    var node3 = Node(3, node2)
    var head = Node(4, node3)
    println("值是${findKthToTail(head, 2)?.value}")
}

/**
 * 一次遍历找到倒数第k个元素
 */
fun findKthToTail(head: Node?, k: Int): Node?{

    if(head == null || k < 1) return null

    //pointer指向头指针
    var pointer: Node? = head
    //pointer先走k-1个位置
    for (i in 1 until k){
        if(pointer?.nextNode != null){
            pointer = pointer.nextNode
        }else{
            return null
        }
    }

    var temp = head
    //pointer走了k-1个位置之后，head开始走
    while (pointer?.nextNode != null){
        pointer = pointer.nextNode
        temp = temp?.nextNode
    }

    return temp
}
