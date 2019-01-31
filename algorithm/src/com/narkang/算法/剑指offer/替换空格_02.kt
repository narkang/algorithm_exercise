package com.narkang.算法

import com.sun.xml.internal.fastinfoset.util.StringArray

/*
* 先判断字符串中空格的数量。根据数量判断该字符串有没有足够的空间替换成"%20"。

如果有足够空间，计算出需要的空间。根据最终需要的总空间，维护一个指针在最后。
从后到前，遇到非空的就把该值挪到指针指向的位置，然后指针向前一位，遇到“ ”，则指针前移，依次替换为“02%”。
*
* */
fun main(args: Array<String>) {
    val s = "we are family"
    replaceBlank(s)
}

/**
 *  获取空格数
 */
fun getBlankNum(s: String): Int{
    var count = 0
    s.forEach {
        if(it == ' '){
            count++
        }
    }
    return count
}

fun printArray(s: Array<Char?>){
    s.forEach {
        print(it)
    }
    print('\n')
}

fun replaceBlank(testString: String){

    //判空
    if(testString.isEmpty()){
        return
    }

    val origStringLength = testString.length
    val descStringLength = getBlankNum(testString) * 2 + origStringLength

    val tempArray = arrayOfNulls<Char>(descStringLength)
    val testArray = arrayOfNulls<Char>(testString.length)
    var index = 0
    testString.forEach {
        testArray[index] = it
        index++
    }

    System.arraycopy(testArray, 0, tempArray, 0, testString.length) //将源数组里面的内容拷贝到新数组

    var indexOfOrigin = origStringLength - 1
    var indexOfDesc = descStringLength - 1

    while (indexOfOrigin >= 0 && indexOfOrigin != indexOfDesc){
        if(tempArray[indexOfOrigin] == ' '){
            tempArray[indexOfDesc--] = '%'
            tempArray[indexOfDesc--] = '0'
            tempArray[indexOfDesc--] = '2'
        }else{
            tempArray[indexOfDesc--] = tempArray[indexOfOrigin]
        }
        indexOfOrigin--
    }
    printArray(tempArray)
}


