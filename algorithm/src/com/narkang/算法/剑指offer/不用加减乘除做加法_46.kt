/**
 *  写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 */
fun main(args: Array<String>) {
    println(add(16, 17))
}

fun add(_n1: Int, _n2: Int): Int{

    var n1 = _n1
    var n2 = _n2
    var sum: Int  //求和
    var carry: Int //是否有二进制位

    do{

        sum = n1 xor n2
        carry = (n1 and n2) shl 1
        n1 = sum
        n2 = carry

    }while (carry != 0)

    return sum

}