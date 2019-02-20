import java.lang.NumberFormatException

/**
 *   实现一个函数stringToInt,实现把字符串转换成整数这个功能，不能使用atoi或者其他类似的库函数。
 */
fun main(args: Array<String>) {
    var s = "-89"
    println(stringToInt(s))
}

fun stringToInt(num: String): Int{

    if(num.isEmpty()) throw NumberFormatException(num)
    val first = num[0]
    return when (first) {
        '-' -> {
            parseString(num, 1, false)
        }
        '+' -> {
            parseString(num, 1, true)
        }
        in '0'..'9' -> {
            parseString(num, 0, true)
        }
        else -> throw NumberFormatException(num)
    }
}

/**
 *  解析字符串
 */
fun parseString(num: String, _index: Int, positive: Boolean): Int{

    var index = _index

    if(num.length <= index){
        throw NumberFormatException(num)
    }

    var temp = 0
    var result: Int

    while (index < num.length && isDigit(num[index])){
        temp = temp * 10 + (num[index] - '0')

        if(temp > 0x8000_0000L){
            throw NumberFormatException(num)
        }
        index ++
    }

    if(positive){
        if(temp >= 0x8000_0000){
            throw NumberFormatException(num)
        }else{
            result = temp
        }
    }else{
        result = -temp
    }

    return result
}

fun isDigit(c: Char): Boolean{
    return c in '0'..'9'
}