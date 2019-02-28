/**
 *  地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 *  举例分析
 *  例如，当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.请问该机器人能够达到多少格子？
 */
fun main(args: Array<String>) {

    println("机器人能够达到${moveCount(4, 4, 4)}格子")

}

/**
 *  threshold: 约束值
 *  rows: 行数
 *  cols: 列数
 */
fun moveCount(threshold: Int, rows: Int, cols: Int): Int{

    //定义rows*cols个boolean判断标志，表示是否访问过该位置，默认值是false
    val visited = arrayOfNulls<Boolean>(rows * cols)
    for (i in 0 until rows * cols){
        visited[i] = false
    }

    return moveCountCore(threshold, rows, cols, 0, 0, visited)
}

/**
 *  递归回溯
 *  threshold: 约束值
 *  rows: 行数
 *  cols: 列数
 *  row: 当前第几行
 *  col: 当前第几列
 *  visited: 访问的标记数组
 */
fun moveCountCore(threshold: Int, rows: Int, cols: Int, row: Int, col: Int, visited: Array<Boolean?>): Int{

    var count = 0

    if(check(threshold, rows, cols, row, col, visited)){
        visited[row * cols + col] = true

        count = 1 + moveCountCore(threshold, rows, cols, row-1, col, visited) +
                    moveCountCore(threshold, rows, cols, row, col-1, visited) +
                    moveCountCore(threshold, rows, cols, row+1, col, visited) +
                    moveCountCore(threshold, rows, cols, row, col+1, visited)
    }

    return count

}

fun check(threshold: Int, rows: Int, cols: Int, row: Int, col: Int, visited: Array<Boolean?>): Boolean{

    if(row in 0..(rows - 1) && col in 0..(cols-1)
            &&(getDigitSum(row) + getDigitSum(col) <= threshold)
            &&!visited[row * cols + col]!!)
        return true

    return false
}

fun getDigitSum(_number: Int): Int{

    var number = _number
    var sum = 0

    while (number > 0){
        sum += number % 10
        number /= 10
    }

    return sum

}