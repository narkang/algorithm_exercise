package com.narkang.算法

/**
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字。
 */
fun main(args: Array<String>) {

    var numbers = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    printMatrixClockWisely(numbers)

}

/**
 *  顺时针打印矩阵
 */
fun printMatrixClockWisely(numbers: Array<IntArray>?){

    if(numbers == null) return

    //记录一圈开始的行
    var x = 0
    //记录一圈开始的列
    var y = 0

    while (x*2 < numbers.size && y*2 < numbers[0].size){

        printMatrixInCircle(numbers, x, y)

        x++
        y++
    }
}

fun printMatrixInCircle(numbers: Array<IntArray>, x: Int, y: Int){

    var rows = numbers.size    //行数
    var cols = numbers[0].size //列数

    //输出环的上面一行
    for(i in y .. cols - 1 - y){
        printNumber(numbers[x][i])
    }
    println()

    //输出环的右边一列
    //条件有两列
    if(rows - x - 1 > x){
        for(i in x+1 until rows){
            printNumber(numbers[i][cols - 1 - y])
        }
    }
    println()

    //输出环的下面一列
    //条件有两列，以及有两行
    if(rows - x - 1 > x && cols - y - 1 > y){
        for(i in cols - y - 1 - 1 downTo y){
            printNumber(numbers[rows- x - 1][i])
        }
    }
    println()

    //输出环的左边一列
    //条件有两行，并且有三列
    if(cols - y - 1 > y && rows - 1 - x > x + 1){
        for(i in rows - 1 - x - 1 downTo x + 1){
            printNumber(numbers[i][y])
        }
    }
    println()
}

fun printNumber(number: Int){
    print("$number\t")
}