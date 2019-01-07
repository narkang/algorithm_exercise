package com.narkang.算法

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。
 * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、
 * cab 和cba 。
 */
fun main(args: Array<String>) {

    var chars = charArrayOf('a', 'b', 'c')
    permutation(chars)

}

fun permutation(chars: CharArray){

    if(chars == null || chars.isEmpty()) return
    permutation(chars, 0)
}

fun permutation(chars: CharArray, begin: Int){

    if(chars.size - 1 == begin){
        println(String(chars))
    }else{
        var temp: Char?
        for(i in begin until chars.size){
            temp = chars[begin]
            chars[begin] = chars[i]
            chars[i] = temp

            // 处理下一个位置
            permutation(chars, begin + 1)
        }
    }
}