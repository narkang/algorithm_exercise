package com.narkang.算法

/**
 *  https://blog.csdn.net/jsqfengbao/article/details/47375263
 * 我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 * 举例说明：
 * 例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1当做第一个丑数。
 */
fun main(args: Array<String>) {
    var index = 10
    println("第${index}个丑数是${getUglyNumber(index)}")
    println("----------------------------------------")
    println("第${index}个丑数是${getUglyNumber2(index)}")
}

//方法一
fun getUglyNumber(index: Int): Int {
    if (index <= 0) return 0

    var number = 0    //要返回的数
    var uglyFound = 0 //丑数的个数

    while (uglyFound < index) {
        number++
        if (isUgly(number)) {
//            println(number)
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

//方法二
fun getUglyNumber2(index: Int): Int?{

    var uglyArray = arrayOfNulls<Int>(index)
    uglyArray[0] = 1
    var p0 = 0
    var p1 = 0
    var p2 = 0

    for (i in 1 until index){
        var min = min(uglyArray[p0]!!.times(2), uglyArray[p1]!!.times(3), uglyArray[p2]!!.times(5))
        uglyArray[i] = min
        while (uglyArray[p0]!!.times(2) <= uglyArray[i]!!) p0 ++
        while (uglyArray[p1]!!.times(3) <= uglyArray[i]!!) p1 ++
        while (uglyArray[p2]!!.times(5) <= uglyArray[i]!!) p2 ++
    }

    return uglyArray[index-1]

}

fun min(p0: Int, p1: Int, p2: Int): Int{
    var min = if(p0 < p1) p0 else p1
    return if(min < p2) min else p2
}