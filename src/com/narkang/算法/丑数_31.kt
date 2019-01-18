package com.narkang.算法

/**
 *  https://blog.csdn.net/jsqfengbao/article/details/47375263
 * 我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 * 举例说明：
 * 例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1当做第一个丑数。
 */
fun main(args: Array<String>) {
    println("第index个丑数是${getUglyNumber(10)}")
}

//方法一
fun getUglyNumber(index: Int): Int {
    if (index <= 0) return 0

    var number = 0    //要返回的数
    var uglyFound = 0 //丑数的个数

    while (uglyFound < index) {
        number++
        if (isUgly(number)) {
            println(number)
            uglyFound ++
        }
    }

    return number
}

fun isUgly(_number: Int): Boolean {
    var number = _number
    while (number % 2 == 0) number /= 2
    while (number % 3 == 0) number /= 3
    while (number % 5 == 0) number /= 5

    return number == 1
}