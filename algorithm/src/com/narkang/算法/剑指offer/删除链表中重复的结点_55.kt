import com.narkang.算法.ListNode

/**
 * 在一个排序的链表中，如何删除重复的结点？
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
fun main(args: Array<String>) {
    var head = ListNode(0)
    var node1 = ListNode(1)
    var node2 = ListNode(1)
    var node3 = ListNode(3)
    var node4 = ListNode(4)
    var node5 = ListNode(4)
    var node6 = ListNode(6)
    var node7 = ListNode(7)
    var node8 = ListNode(8)
    var node9 = ListNode(8)
    var node10 = ListNode(10)
    var node11 = ListNode(11)
    var node12 = ListNode(11)

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

    var resultListNode = deleteDuplication(head)
    while (resultListNode != null){
        println(resultListNode.value)
        resultListNode = resultListNode.next
    }
}

fun deleteDuplication(head: ListNode): ListNode?{

    val first = ListNode(-1)

    first.next = head

    var p: ListNode? = head
    var last = first

    while (p != null && p.next != null){
        if(p.value == p!!.next!!.value){
            var value = p.value
            while (p != null && p!!.value == value){
                if(p.next != null) p = p.next
                else p = null
            }
            last.next = p
        }else{
            last = p
            p = p!!.next!!
        }
    }

    return first.next
}