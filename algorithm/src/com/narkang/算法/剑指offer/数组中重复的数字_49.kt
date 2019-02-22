/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但
 * 不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 举例说明
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
fun main(args: Array<String>) {
    val number = intArrayOf(6,3,1,0,2,5,3)
    val duplicateNumber = findDuplicatedNumber(number)
    println("重复元素是$duplicateNumber")
}

fun findDuplicatedNumber(_number: IntArray): Int{

    var number = _number
    val length = _number.size

    number.forEach {
        if(it < 0 || it > length - 1)  throw IllegalArgumentException("Wrong Numbers in Array")
    }

    for(i in 0 until length){
        while (number[i] != i){
            if(number[i] == number[number[i]]){
                return number[i]
            }
            val temp = number[i]
            number[i] = number[temp]
            number[temp] = temp
        }
    }

    return -1
}