package com.narkang.算法

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。
 * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、
 * cab 和cba 。
 */
fun main(args: Array<String>) {

    var chars = charArrayOf('a', 'b', 'c', 'd')
    permutation(chars)

}

fun permutation(chars: CharArray){

    if(chars == null || chars.isEmpty()) return
    permutation(chars, 0)
}

fun permutation(chars: CharArray, begin: Int){
    var _chars = chars
    if(_chars.size - 1 == begin){
        println(String(_chars))
    }else{
        var temp: Char?
        for(i in begin until _chars.size){
            temp = _chars[begin]
            _chars[begin] = _chars[i]
            _chars[i] = temp

            // 处理下一个位置
            permutation(_chars, begin + 1)
            //由于数据交互了，所以要还原回来
            temp = _chars[begin]
            _chars[begin] = _chars[i]
            _chars[i] = temp
        }
    }
}