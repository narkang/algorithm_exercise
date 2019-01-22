package com.narkang.算法

/*
*    Step1.和二分查找法一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。

　　  Step2.接着我们可以找到数组中间的元素：

　　         如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元
            素。此时数组中最小的元素应该位于该中间元素的后面。我们可以把第一个指针指向该中间元素，这样可
            以缩小寻找的范围。移动之后的第一个指针仍然位于前面的递增子数组之中。如果中间元素位于后面的递
            增子数组，那么它应该小于或者等于第二个指针指向的元素。此时该数组中最小的元素应该位于该中间
            元素的前面。

　　  Step3.接下来我们再用更新之后的两个指针，重复做新一轮的查找。
* */

fun getMin(num: Array<Int>): Int{
    if(num.isEmpty()){
       throw RuntimeException("数组元素为空")
    }

    var firstIndex = 0
    var lastIndex = num.size - 1

    var midIndex = firstIndex
    while (num[firstIndex] >= num[lastIndex]){
        //如果firstIndex和lastIndex指向相邻的两个元素，则lastIndex指向的是最小元素
        if(lastIndex - firstIndex == 1){
            midIndex = lastIndex
            break
        }
        midIndex = (firstIndex + lastIndex) / 2
        //三个元素相等
        if(num[firstIndex] == num[midIndex] && num[midIndex] == num[lastIndex]){
            return getMinInOrder(num, firstIndex, lastIndex)
        }
        //缩小查找范围 在前面
        if(num[firstIndex] <= num[midIndex]){
            firstIndex = midIndex
        //在后面
        }else if(num[lastIndex] >= num[midIndex]){
            lastIndex = midIndex
        }
    }
    return num[midIndex]
}

//顺序比较
fun getMinInOrder(num: Array<Int>, firstIndex: Int, lastIndex: Int): Int{
    var result = num[firstIndex]
    var i = firstIndex + 1
    while (i<=lastIndex){
        if(num[i] < result){
            result = num[i]
        }
        i++
    }
    return result
}

fun main(args: Array<String>) {
    var num = arrayOf(0, 1, 2, 3, 4)
    println("----->>>>"+getMin(num))
}