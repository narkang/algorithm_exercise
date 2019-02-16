/**
 *  0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏
 *  里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
 */
fun main(args: Array<String>) {
    josephus(10, 2)
}

fun josephus(n: Int, m: Int){

    var list = ArrayList<Int>(n)

    for(i in 0 until n){
        list.add(i)
    }

    var index = 0
    while (list.size > 0){

        index = (index + m) % list.size - 1
        if(index < 0){
            println(list[list.size - 1])
            list.remove(list[list.size - 1])
            index = 0
        }else{
            println(list[index])
            list.remove(list[index])
        }
    }
}