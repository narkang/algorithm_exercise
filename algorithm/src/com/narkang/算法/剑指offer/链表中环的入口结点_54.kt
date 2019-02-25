import com.narkang.算法.ListNode

/**
 * 一个链表中包含环，如何找出环的入口结点？
 */
fun main(args: Array<String>) {
    var head = ListNode(0)
    var node1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(3)
    var node4 = ListNode(4)
    var node5 = ListNode(5)
    var node6 = ListNode(6)
    var node7 = ListNode(7)
    var node8 = ListNode(8)
    var node9 = ListNode(9)
    var node10 = ListNode(10)
    var node11 = ListNode(11)
    var node12 = ListNode(12)

    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = node9
    node9.next = node10
    node10.next = node11
    node11.next = node12
    node12.next = null

    val enterNode = getEnterNode(head)
    enterNode?.let { println("环的入口节点值是${it.value}") }
    if(enterNode == null) println("链表没有环")
}

fun getEnterNode(head: ListNode?): ListNode?{

    if(head == null) return null

    // 环中相遇的节点
    var meetNode = meetNode(head)
    // 环中节点长度
    var ringLength = 0
    if(meetNode != null){
        var tempNode = meetNode
        meetNode = meetNode.next
        while (tempNode != meetNode){
            ringLength++
            meetNode = meetNode!!.next
        }
        ringLength++
    }else{
        return null
    }

    var ahead = head  //第一个节点
    var behind = head //第二个节点

    while (ringLength > 0){
        ahead = ahead!!.next
        ringLength --
    }

    while (ahead != behind){
        ahead = ahead!!.next
        behind = behind!!.next
    }

    return behind
}

/**
 * 相遇的节点
 */
fun meetNode(head: ListNode?): ListNode?{

    if(head == null){
        return null
    }

    var behind = head.next
    if(behind == null) return null

    var ahead = behind.next

    while (behind != null && ahead != null){

        if(behind == ahead) return ahead
        //behind指针向前移动一步
        behind = behind.next
        //ahead指针向前移动两步
        ahead = ahead.next
        if(ahead != null){
            ahead = ahead.next
        }
    }

    return null
}