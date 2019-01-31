package com.narkang.算法

/**
 *  输入数字n，按顺序打印出从1到n位最大十进数的数值。比如输入3，则打印出1、2、3一直到最大三位数即999。
 */
fun main(args: Array<String>) {

    printOneToNthDigits(2)

}

fun printOneToNthDigits(n: Int){

    if(n < 0) throw RuntimeException("输入数必须大于0")

    val array = Array(n) {0}

    while (addOne(array) == 0){
        //打印数组值
        printArray(array)
    }
}

fun addOne(array: Array<Int>): Int{

    var carry = 1
    var index = array.size

    do{

        index --
        array[index] += carry
        carry = array[index] / 10
        array[index] %= 10  //array中每个数不能大于等于10

    }while (carry != 0 && index > 0)

    //index = 0 说明已经处理到最高位，carry>0说明有进位
    if(carry > 0 && index == 0){
        return 1 //说明已经处理到最高位，并且已经进位
    }

    return 0
}

fun printArray(array: Array<Int>){

    var index = 0
    //排除数组前面为0的数字
    while (index < array.size && array[index] == 0){
        index ++
    }

    //从不是0的位置开始打印数组元素
    for (i in index until array.size){
        print(array[i])
    }

    if(index < array.size) println()
}