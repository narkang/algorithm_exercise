package com.narkang.算法

object 二维数组查找指定元素_01 {

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val number = 19
        val valueInfo = if (find(matrix, number)) "存在该元素" else "不存在该元素"
        println(valueInfo)
    }

    /**
     * 判断一个二维数组中是否有指定的元素
     * true包含 false不包含
     *
     * 思路
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
     *
     * 如果该数字大于要查找的数字，剔除这个数字所在的行：如果该数字小于要查找的数字，剔除这个数字所在的列。
     *
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
     */
    fun find(matrix: Array<IntArray>?, number: Int): Boolean {

        //先判空
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }

        val rows = matrix.size //数组的行数
        val cols = matrix[0].size //数据的列数

        var row = 0 //第0行
        var col = cols - 1 //最后一列开始比较

        while (row in 0..(rows - 1) && col >= 0 && col < cols) {
            val value = matrix[row][col]
            when {
                value == number -> //待比较的元素是否相等，说明存在该元素
                    return true
                value > number -> col--
                value < number -> row++
            }
        }

        return false
    }

}
